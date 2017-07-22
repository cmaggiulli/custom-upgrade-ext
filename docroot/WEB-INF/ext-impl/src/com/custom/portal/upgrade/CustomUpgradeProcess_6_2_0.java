package com.custom.portal.upgrade;

import com.custom.portal.upgrade.v6_2_0.CustomUpgradeDocumentLibrary;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.upgrade.UpgradeProcess_6_2_0;
import com.liferay.portal.upgrade.v6_2_0.UpgradeAnnouncements;
import com.liferay.portal.upgrade.v6_2_0.UpgradeAssetPublisher;
import com.liferay.portal.upgrade.v6_2_0.UpgradeBlogs;
import com.liferay.portal.upgrade.v6_2_0.UpgradeBlogsAggregator;
import com.liferay.portal.upgrade.v6_2_0.UpgradeCalendar;
import com.liferay.portal.upgrade.v6_2_0.UpgradeCompany;
import com.liferay.portal.upgrade.v6_2_0.UpgradeCustomizablePortlets;
import com.liferay.portal.upgrade.v6_2_0.UpgradeDynamicDataListDisplay;
import com.liferay.portal.upgrade.v6_2_0.UpgradeDynamicDataMapping;
import com.liferay.portal.upgrade.v6_2_0.UpgradeGroup;
import com.liferay.portal.upgrade.v6_2_0.UpgradeImageGallery;
import com.liferay.portal.upgrade.v6_2_0.UpgradeJournal;
import com.liferay.portal.upgrade.v6_2_0.UpgradeLayout;
import com.liferay.portal.upgrade.v6_2_0.UpgradeLayoutFriendlyURL;
import com.liferay.portal.upgrade.v6_2_0.UpgradeLayoutRevision;
import com.liferay.portal.upgrade.v6_2_0.UpgradeLayoutSet;
import com.liferay.portal.upgrade.v6_2_0.UpgradeLayoutSetBranch;
import com.liferay.portal.upgrade.v6_2_0.UpgradeMessageBoards;
import com.liferay.portal.upgrade.v6_2_0.UpgradeMessageBoardsAttachments;
import com.liferay.portal.upgrade.v6_2_0.UpgradePortletItem;
import com.liferay.portal.upgrade.v6_2_0.UpgradePortletPreferences;
import com.liferay.portal.upgrade.v6_2_0.UpgradeRepository;
import com.liferay.portal.upgrade.v6_2_0.UpgradeSchema;
import com.liferay.portal.upgrade.v6_2_0.UpgradeSearch;
import com.liferay.portal.upgrade.v6_2_0.UpgradeSocial;
import com.liferay.portal.upgrade.v6_2_0.UpgradeUser;
import com.liferay.portal.upgrade.v6_2_0.UpgradeWiki;
import com.liferay.portal.upgrade.v6_2_0.UpgradeWikiAttachments;

public class CustomUpgradeProcess_6_2_0 extends UpgradeProcess_6_2_0 {
    	private static final Log LOG = LogFactoryUtil.getLog(CustomUpgradeProcess_6_2_0.class);
    	
    	@Override
    	public int getThreshold() {
    		return ReleaseInfo.RELEASE_6_2_0_BUILD_NUMBER;
    	}

    	@Override
    	protected void doUpgrade() throws Exception {
    	    LOG.info("Start upgrade " + UpgradeSchema.class.getSimpleName());
            upgrade(UpgradeSchema.class);
            
    	    LOG.info("Start upgrade " + UpgradeAnnouncements.class.getSimpleName());
            upgrade(UpgradeAnnouncements.class);
            
    	    LOG.info("Start upgrade " + UpgradeAssetPublisher.class.getSimpleName());
            upgrade(UpgradeAssetPublisher.class);

    	    LOG.info("Start upgrade " + UpgradeBlogs.class.getSimpleName());
            upgrade(UpgradeBlogs.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeBlogsAggregator.class.getSimpleName());
            upgrade(UpgradeBlogsAggregator.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeCalendar.class.getSimpleName());
            upgrade(UpgradeCalendar.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeCompany.class.getSimpleName());
            upgrade(UpgradeCompany.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeCustomizablePortlets.class.getSimpleName());
            upgrade(UpgradeCustomizablePortlets.class);
    	    
    	    LOG.info("Start upgrade " + CustomUpgradeDocumentLibrary.class.getSimpleName());
            upgrade(CustomUpgradeDocumentLibrary.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeDynamicDataListDisplay.class.getSimpleName());
            upgrade(UpgradeDynamicDataListDisplay.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeDynamicDataMapping.class.getSimpleName());
            upgrade(UpgradeDynamicDataMapping.class);

    	    LOG.info("Start upgrade " + UpgradeGroup.class.getSimpleName());
            upgrade(UpgradeGroup.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeImageGallery.class.getSimpleName());
            upgrade(UpgradeImageGallery.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeJournal.class.getSimpleName());
            upgrade(UpgradeJournal.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeLayout.class.getSimpleName());
            upgrade(UpgradeLayout.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeLayoutFriendlyURL.class.getSimpleName());
            upgrade(UpgradeLayoutFriendlyURL.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeLayoutRevision.class.getSimpleName());
            upgrade(UpgradeLayoutRevision.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeLayoutSet.class.getSimpleName());
            upgrade(UpgradeLayoutSet.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeLayoutSetBranch.class.getSimpleName());
            upgrade(UpgradeLayoutSetBranch.class);
    	    
    	    LOG.info("Start upgrade " + UpgradeMessageBoards.class.getSimpleName());
            upgrade(UpgradeMessageBoards.class);

    	    LOG.info("Start upgrade " + UpgradeMessageBoardsAttachments.class.getSimpleName());
            upgrade(UpgradeMessageBoardsAttachments.class);

    	    LOG.info("Start upgrade " + UpgradePortletItem.class.getSimpleName());
            upgrade(UpgradePortletItem.class);

    	    LOG.info("Start upgrade " + UpgradePortletPreferences.class.getSimpleName());
            upgrade(UpgradePortletPreferences.class);

    	    LOG.info("Start upgrade " + UpgradeRepository.class.getSimpleName());
            upgrade(UpgradeRepository.class);

    	    LOG.info("Start upgrade " + UpgradeSearch.class.getSimpleName());
            upgrade(UpgradeSearch.class);

    	    LOG.info("Start upgrade " + UpgradeSocial.class.getSimpleName());
            upgrade(UpgradeSocial.class);

    	    LOG.info("Start upgrade " + UpgradeUser.class.getSimpleName());
            upgrade(UpgradeUser.class);

    	    LOG.info("Start upgrade " + UpgradeWiki.class.getSimpleName());
            upgrade(UpgradeWiki.class);

    	    LOG.info("Start upgrade " + UpgradeWikiAttachments.class.getSimpleName());
            upgrade(UpgradeWikiAttachments.class);
    	}
}
