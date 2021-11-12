package com.pallaw.tmassignment.Data.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Pallaw Pathak on 2019-06-14. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class TMResponse {

    @Expose @SerializedName("share_app_link") public String shareAppLink;
    @Expose @SerializedName("share_app_text") public String shareAppText;
    @Expose @SerializedName("static_images") public StaticImagesBean staticImages;
    @Expose @SerializedName("deletion_reasons") public List<DeletionReasonsBean> deletionReasons;
    @Expose @SerializedName("deactivation_reasons") public List<DeactivationReasonsBean> deactivationReasons;
    @Expose @SerializedName("user_group_report_reasons") public List<UserGroupReportReasonsBean> userGroupReportReasons;
    @Expose @SerializedName("user_report_reasons") public List<UserReportReasonsBean> userReportReasons;
    @Expose @SerializedName("user_unmatch_reasons") public List<UserUnmatchReasonsBean> userUnmatchReasons;
    @Expose @SerializedName("group_report_reasons") public List<GroupLeaveReasonsBean> groupReportReasons;
    @Expose @SerializedName("group_leave_reasons") public List<GroupLeaveReasonsBean> groupLeaveReasons;
    @Expose @SerializedName("orientations") public List<OrientationsBean> orientations;
    @Expose @SerializedName("interests") public List<String> interests;
    @Expose @SerializedName("tribes") public List<String> tribes;
    @Expose @SerializedName("hiv_statuses") public List<String> hivStatuses;
    @Expose @SerializedName("profile_questions") public List<ProfileQuestionsBean> profileQuestions;
    @Expose @SerializedName("compatibility_questions") public List<CompatibilityQuestionsBean> compatibilityQuestions;


    public String getShareAppLink() {
        return shareAppLink;
    }

    public void setShareAppLink(String shareAppLink) {
        this.shareAppLink = shareAppLink;
    }

    public String getShareAppText() {
        return shareAppText;
    }

    public void setShareAppText(String shareAppText) {
        this.shareAppText = shareAppText;
    }

    public StaticImagesBean getStaticImages() {
        return staticImages;
    }

    public void setStaticImages(StaticImagesBean staticImages) {
        this.staticImages = staticImages;
    }

    public List<DeletionReasonsBean> getDeletionReasons() {
        return deletionReasons;
    }

    public void setDeletionReasons(List<DeletionReasonsBean> deletionReasons) {
        this.deletionReasons = deletionReasons;
    }

    public List<DeactivationReasonsBean> getDeactivationReasons() {
        return deactivationReasons;
    }

    public void setDeactivationReasons(List<DeactivationReasonsBean> deactivationReasons) {
        this.deactivationReasons = deactivationReasons;
    }

    public List<UserGroupReportReasonsBean> getUserGroupReportReasons() {
        return userGroupReportReasons;
    }

    public void setUserGroupReportReasons(List<UserGroupReportReasonsBean> userGroupReportReasons) {
        this.userGroupReportReasons = userGroupReportReasons;
    }

    public List<UserReportReasonsBean> getUserReportReasons() {
        return userReportReasons;
    }

    public void setUserReportReasons(List<UserReportReasonsBean> userReportReasons) {
        this.userReportReasons = userReportReasons;
    }

    public List<UserUnmatchReasonsBean> getUserUnmatchReasons() {
        return userUnmatchReasons;
    }

    public void setUserUnmatchReasons(List<UserUnmatchReasonsBean> userUnmatchReasons) {
        this.userUnmatchReasons = userUnmatchReasons;
    }

    public List<GroupLeaveReasonsBean> getGroupReportReasons() {
        return groupReportReasons;
    }

    public void setGroupReportReasons(List<GroupLeaveReasonsBean> groupReportReasons) {
        this.groupReportReasons = groupReportReasons;
    }

    public List<GroupLeaveReasonsBean> getGroupLeaveReasons() {
        return groupLeaveReasons;
    }

    public void setGroupLeaveReasons(List<GroupLeaveReasonsBean> groupLeaveReasons) {
        this.groupLeaveReasons = groupLeaveReasons;
    }

    public List<OrientationsBean> getOrientations() {
        return orientations;
    }

    public void setOrientations(List<OrientationsBean> orientations) {
        this.orientations = orientations;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getTribes() {
        return tribes;
    }

    public void setTribes(List<String> tribes) {
        this.tribes = tribes;
    }

    public List<String> getHivStatuses() {
        return hivStatuses;
    }

    public void setHivStatuses(List<String> hivStatuses) {
        this.hivStatuses = hivStatuses;
    }

    public List<ProfileQuestionsBean> getProfileQuestions() {
        return profileQuestions;
    }

    public void setProfileQuestions(List<ProfileQuestionsBean> profileQuestions) {
        this.profileQuestions = profileQuestions;
    }

    public List<CompatibilityQuestionsBean> getCompatibilityQuestions() {
        return compatibilityQuestions;
    }

    public void setCompatibilityQuestions(List<CompatibilityQuestionsBean> compatibilityQuestions) {
        this.compatibilityQuestions = compatibilityQuestions;
    }
}
