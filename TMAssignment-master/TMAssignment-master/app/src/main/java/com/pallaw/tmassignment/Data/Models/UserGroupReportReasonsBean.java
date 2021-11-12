package com.pallaw.tmassignment.Data.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserGroupReportReasonsBean {
    @Expose @SerializedName("rank") public int rank;
    @Expose @SerializedName("type") public String type;
    @Expose @SerializedName("name") public String name;
    @Expose @SerializedName("updated_at") public String updatedAt;
    @Expose @SerializedName("created_at") public String createdAt;
    @Expose @SerializedName("id") public int id;
}
