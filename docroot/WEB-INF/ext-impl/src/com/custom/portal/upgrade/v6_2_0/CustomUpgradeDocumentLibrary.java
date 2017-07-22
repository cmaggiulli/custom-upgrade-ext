package com.custom.portal.upgrade.v6_2_0;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.auth.FullNameGenerator;
import com.liferay.portal.security.auth.FullNameGeneratorFactory;
import com.liferay.portal.upgrade.UpgradeProcessUtil;
import com.liferay.portal.upgrade.v6_2_0.util.DLFileEntryTypeTable;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CustomUpgradeDocumentLibrary extends UpgradeProcess {
    private static final Log LOG = LogFactoryUtil.getLog(CustomUpgradeDocumentLibrary.class);

    protected void deleteChecksumDirectory() throws Exception {
	LOG.info("Start deleteChecksumDirectory method");
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
	    con = DataAccess.getUpgradeOptimizedConnection();

	    ps = con.prepareStatement("select distinct companyId from DLFileEntry");

	    LOG.info("Executing query " + ps.toString());
	    rs = ps.executeQuery();

	    while (rs.next()) {
		long companyId = rs.getLong("companyId");
		int row = rs.getRow();
		
		LOG.info("Row #" + row + " companyId "+ companyId);
		
		try {
		    DLStoreUtil.deleteDirectory(companyId, 0, "checksum");
		    LOG.info("Deleted company "+ companyId + " row #" + row);
		} catch (Exception e) {
		    LOG.warn("Failed to delete company "+ companyId + " row #" + row + " " + e.getMessage());
		}
	    }
	} finally {
	    LOG.info("Cleanup deleteChecksumDirectory");
	    DataAccess.cleanUp(con, ps, rs);
	}
    }

    protected void deleteTempDirectory() {
	LOG.info("Start deleteTempDirectory method");

	try {
	    DLStoreUtil.deleteDirectory(0, 0, "liferay_temp/");
	    LOG.info("Deleted liferay_temp/");
	} catch (Exception e) {
	    LOG.warn("Failed to delete liferay_temp/ " + e.getMessage());
	}
    }

    @Override
    protected void doUpgrade() throws Exception {
	LOG.info("Start doUpgrade method");
	
	try {
	    LOG.info("Running SQL: alter table DLFileEntryType add fileEntryTypeKey STRING");
	    runSQL("alter table DLFileEntryType add fileEntryTypeKey STRING");

	    LOG.info("Running SQL: alter_column_type DLFileEntryType name STRING null");
	    runSQL("alter_column_type DLFileEntryType name STRING null");

	} catch (SQLException sqle) {
	    LOG.warn(sqle.getMessage());
	    
	    LOG.info("Upgrading table " + DLFileEntryTypeTable.TABLE_NAME);
	    LOG.info("Upgrading columns " + DLFileEntryTypeTable.TABLE_COLUMNS);
	    LOG.info("Upgrading create " + DLFileEntryTypeTable.TABLE_SQL_CREATE);
	    LOG.info("Upgrading indexes " + DLFileEntryTypeTable.TABLE_SQL_ADD_INDEXES);
	    upgradeTable(DLFileEntryTypeTable.TABLE_NAME, DLFileEntryTypeTable.TABLE_COLUMNS, DLFileEntryTypeTable.TABLE_SQL_CREATE, DLFileEntryTypeTable.TABLE_SQL_ADD_INDEXES);
	}

	updateFileEntryTypes();

	// Checksum directory

	deleteChecksumDirectory();

	// Temp directory

	deleteTempDirectory();
    }

    protected String getUserName(long userId) throws Exception {
	LOG.info("Start getUserName method");

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
	    con = DataAccess.getUpgradeOptimizedConnection();

	    ps = con.prepareStatement("select firstName, middleName, lastName from User_ where " + "userId = ?");

	    ps.setLong(1, userId);

	    LOG.info("Executing query " + ps.toString());
	    rs = ps.executeQuery();

	    if (rs.next()) {
		String firstName = rs.getString("firstName");
		String middleName = rs.getString("middleName");
		String lastName = rs.getString("lastName");

		FullNameGenerator fullNameGenerator = FullNameGeneratorFactory.getInstance();

		LOG.info(fullNameGenerator.getFullName(firstName, middleName, lastName));
		return fullNameGenerator.getFullName(firstName, middleName, lastName);
	    }

	    return StringPool.BLANK;
	} finally {
	    LOG.info("Cleanup getUserName");
	    DataAccess.cleanUp(con, ps, rs);
	}
    }

    protected String localize(long companyId, String content, String key) throws Exception {

	String languageId = UpgradeProcessUtil.getDefaultLanguageId(companyId);

	Locale locale = LocaleUtil.fromLanguageId(languageId);

	Map<Locale, String> localizationMap = new HashMap<Locale, String>();

	localizationMap.put(locale, content);

	LOG.info("Updating localization " + locale.toString());
	return LocalizationUtil.updateLocalization(localizationMap, StringPool.BLANK, key, languageId);
    }

    protected void updateFileEntryType(long fileEntryTypeId, long companyId, String fileEntryTypeKey, String name, String description) throws Exception {
	LOG.info("Start updateFileEntryType method");

	Connection con = null;
	PreparedStatement ps = null;

	try {
	    con = DataAccess.getUpgradeOptimizedConnection();

	    ps = con.prepareStatement("update DLFileEntryType set fileEntryTypeKey = ?, name = ?, " + "description = ? where fileEntryTypeId = ?");

	    ps.setString(1, fileEntryTypeKey);
	    ps.setString(2, localize(companyId, name, "Name"));
	    ps.setString(3, localize(companyId, description, "Description"));
	    ps.setLong(4, fileEntryTypeId);

	    LOG.info("Executing query " + ps.toString());
	    ps.executeUpdate();
	} finally {
	    LOG.info("Cleanup updateFileEntryType");
	    DataAccess.cleanUp(con, ps);
	}
    }

    protected void updateFileEntryTypes() throws Exception {
	LOG.info("Start updateFileEntryTypes method");

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
	    con = DataAccess.getUpgradeOptimizedConnection();

	    ps = con.prepareStatement("select fileEntryTypeId, companyId, name, description from " + "DLFileEntryType");

	    LOG.info("Executing query " + ps.toString());
	    rs = ps.executeQuery();

	    while (rs.next()) {
		long fileEntryTypeId = rs.getLong("fileEntryTypeId");
		long companyId = rs.getLong("companyId");
		String name = GetterUtil.getString(rs.getString("name"));
		String description = rs.getString("description");

		if (fileEntryTypeId == DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT) {

		    name = DLFileEntryTypeConstants.NAME_BASIC_DOCUMENT;
		}

		updateFileEntryType(fileEntryTypeId, companyId, StringUtil.toUpperCase(name), name, description);
	    }
	} finally {
	    LOG.info("Cleanup updateFileEntryTypes");
	    DataAccess.cleanUp(con, ps, rs);
	}
    }

}
