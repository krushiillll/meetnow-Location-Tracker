package com.meetnow.location.tracker.Ads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("account_name")
    @Expose
    private String accountName;
    @SerializedName("package_name")
    @Expose
    private String packageName;
    @SerializedName("banner_ads")
    @Expose
    private String bannerAds;
    @SerializedName("banner_ads2")
    @Expose
    private String bannerAds2;
    @SerializedName("native_ads")
    @Expose
    private String nativeAds;
    @SerializedName("native_ads2")
    @Expose
    private String nativeAds2;
    @SerializedName("vpn_key")
    @Expose
    private String vpnKey;
    @SerializedName("vpn_server_url")
    @Expose
    private String vpnServerUrl;
    @SerializedName("vpn_status")
    @Expose
    private String vpnStatus;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("application_name")
    @Expose
    private String applicationName;
    @SerializedName("add_open_ads")
    @Expose
    private String addOpenAds;
    @SerializedName("add_open_ads2")
    @Expose
    private String addOpenAds2;
    @SerializedName("interstitial_ads")
    @Expose
    private String interstitialAds;
    @SerializedName("interstitial_ads2")
    @Expose
    private String interstitialAds2;
    @SerializedName("rewarded_ads")
    @Expose
    private String rewardedAds;
    @SerializedName("rewarded_ads2")
    @Expose
    private String rewardedAds2;
    @SerializedName("interFrequency")
    @Expose
    private String interFrequency;
    @SerializedName("rewarded_frequency")
    @Expose
    private String rewardedFrequency;
    @SerializedName("frequency")
    @Expose
    private String frequency;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("app_version")
    @Expose
    private String appVersion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getBannerAds() {
        return bannerAds;
    }

    public void setBannerAds(String bannerAds) {
        this.bannerAds = bannerAds;
    }

    public String getBannerAds2() {
        return bannerAds2;
    }

    public void setBannerAds2(String bannerAds2) {
        this.bannerAds2 = bannerAds2;
    }

    public String getNativeAds() {
        return nativeAds;
    }

    public void setNativeAds(String nativeAds) {
        this.nativeAds = nativeAds;
    }

    public String getNativeAds2() {
        return nativeAds2;
    }

    public void setNativeAds2(String nativeAds2) {
        this.nativeAds2 = nativeAds2;
    }

    public String getVpnKey() {
        return vpnKey;
    }

    public void setVpnKey(String vpnKey) {
        this.vpnKey = vpnKey;
    }

    public String getVpnServerUrl() {
        return vpnServerUrl;
    }

    public void setVpnServerUrl(String vpnServerUrl) {
        this.vpnServerUrl = vpnServerUrl;
    }

    public String getVpnStatus() {
        return vpnStatus;
    }

    public void setVpnStatus(String vpnStatus) {
        this.vpnStatus = vpnStatus;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getAddOpenAds() {
        return addOpenAds;
    }

    public void setAddOpenAds(String addOpenAds) {
        this.addOpenAds = addOpenAds;
    }

    public String getAddOpenAds2() {
        return addOpenAds2;
    }

    public void setAddOpenAds2(String addOpenAds2) {
        this.addOpenAds2 = addOpenAds2;
    }

    public String getInterstitialAds() {
        return interstitialAds;
    }

    public void setInterstitialAds(String interstitialAds) {
        this.interstitialAds = interstitialAds;
    }

    public String getInterstitialAds2() {
        return interstitialAds2;
    }

    public void setInterstitialAds2(String interstitialAds2) {
        this.interstitialAds2 = interstitialAds2;
    }

    public String getRewardedAds() {
        return rewardedAds;
    }

    public void setRewardedAds(String rewardedAds) {
        this.rewardedAds = rewardedAds;
    }

    public String getRewardedAds2() {
        return rewardedAds2;
    }

    public void setRewardedAds2(String rewardedAds2) {
        this.rewardedAds2 = rewardedAds2;
    }

    public String getInterFrequency() {
        return interFrequency;
    }

    public void setInterFrequency(String interFrequency) {
        this.interFrequency = interFrequency;
    }

    public String getRewardedFrequency() {
        return rewardedFrequency;
    }

    public void setRewardedFrequency(String rewardedFrequency) {
        this.rewardedFrequency = rewardedFrequency;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

}