package com.pallaw.tmassignment.Data.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeactivationReasonsBean {
    @Expose @SerializedName("click_action") public String clickAction;
    @Expose @SerializedName("next_action_text") public String nextActionText;
    @Expose @SerializedName("reason") public String reason;
}
