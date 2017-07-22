package com.custom.portal.verify;

import com.liferay.portal.verify.*;

public class CustomVerifyProcessSuite extends VerifyProcessSuite {

    @Override
    protected void doVerify() throws Exception {
        verify(new VerifyProperties());
        verify(new VerifyDB2());
        verify(new VerifyMySQL());
        verify(new VerifyOracle());
        verify(new VerifySQLServer());
        verify(new VerifyUUID());
        verify(new VerifyPermission());
        verify(new VerifyGroup());
        verify(new VerifyRole());
        verify(new VerifyAsset());
        verify(new VerifyAuditedModel());
        verify(new VerifyBlogs());
        verify(new VerifyBookmarks());
        verify(new VerifyCalendar());
        // verify(new VerifyDocumentLibrary()); Removed due to unpatched bug
        verify(new VerifyDynamicDataMapping());
        verify(new VerifyGroupId());
        verify(new VerifyJournal());
        verify(new VerifyLayout());
        verify(new VerifyMessageBoards());
        verify(new VerifyOrganization());
        verify(new VerifyRegion());
        verify(new VerifyResourcePermissions());
        verify(new VerifyUser());
        verify(new VerifyWiki());
        verify(new VerifyWorkflow());
    }
}