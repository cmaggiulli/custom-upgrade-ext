package com.custom.portal.upgrade;

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
import com.liferay.portal.upgrade.v6_2_0.UpgradeDocumentLibrary;
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
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeSchema.class.getSimpleName());
            upgrade(UpgradeSchema.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeSchema.class.getSimpleName());
            
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeAnnouncements.class.getSimpleName());
            upgrade(UpgradeAnnouncements.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeAnnouncements.class.getSimpleName());
            
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeAssetPublisher.class.getSimpleName());
            upgrade(UpgradeAssetPublisher.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeAssetPublisher.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradeBlogs.class.getSimpleName());
            upgrade(UpgradeBlogs.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeBlogs.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeBlogsAggregator.class.getSimpleName());
            upgrade(UpgradeBlogsAggregator.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeBlogsAggregator.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeCalendar.class.getSimpleName());
            upgrade(UpgradeCalendar.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeCalendar.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeCompany.class.getSimpleName());
            upgrade(UpgradeCompany.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeCompany.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeCustomizablePortlets.class.getSimpleName());
            upgrade(UpgradeCustomizablePortlets.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeCustomizablePortlets.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeDocumentLibrary.class.getSimpleName());
            upgrade(UpgradeDocumentLibrary.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeDocumentLibrary.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeDynamicDataListDisplay.class.getSimpleName());
            upgrade(UpgradeDynamicDataListDisplay.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeDynamicDataListDisplay.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeDynamicDataMapping.class.getSimpleName());
            upgrade(UpgradeDynamicDataMapping.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeDynamicDataMapping.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradeGroup.class.getSimpleName());
            upgrade(UpgradeGroup.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeGroup.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeImageGallery.class.getSimpleName());
            upgrade(UpgradeImageGallery.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeImageGallery.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeJournal.class.getSimpleName());
            upgrade(UpgradeJournal.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeJournal.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeLayout.class.getSimpleName());
            upgrade(UpgradeLayout.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeLayout.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeLayoutFriendlyURL.class.getSimpleName());
            upgrade(UpgradeLayoutFriendlyURL.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeLayoutFriendlyURL.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeLayoutRevision.class.getSimpleName());
            upgrade(UpgradeLayoutRevision.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeLayoutRevision.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeLayoutSet.class.getSimpleName());
            upgrade(UpgradeLayoutSet.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeLayoutSet.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeLayoutSetBranch.class.getSimpleName());
            upgrade(UpgradeLayoutSetBranch.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeLayoutSetBranch.class.getSimpleName());
    	    
    	    LOG.info("Custom Log Begin Upgrade " + UpgradeMessageBoards.class.getSimpleName());
            upgrade(UpgradeMessageBoards.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeMessageBoards.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradeMessageBoardsAttachments.class.getSimpleName());
            upgrade(UpgradeMessageBoardsAttachments.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeMessageBoardsAttachments.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradePortletItem.class.getSimpleName());
            upgrade(UpgradePortletItem.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradePortletItem.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradePortletPreferences.class.getSimpleName());
            upgrade(UpgradePortletPreferences.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradePortletPreferences.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradeRepository.class.getSimpleName());
            upgrade(UpgradeRepository.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeRepository.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradeSearch.class.getSimpleName());
            upgrade(UpgradeSearch.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeSearch.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradeSocial.class.getSimpleName());
            upgrade(UpgradeSocial.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeSocial.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradeUser.class.getSimpleName());
            upgrade(UpgradeUser.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeUser.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradeWiki.class.getSimpleName());
            upgrade(UpgradeWiki.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeWiki.class.getSimpleName());

    	    LOG.info("Custom Log Begin Upgrade " + UpgradeWikiAttachments.class.getSimpleName());
            upgrade(UpgradeWikiAttachments.class);
    	    LOG.info("Custom Log End Upgrade " + UpgradeWikiAttachments.class.getSimpleName());

    	}
}
