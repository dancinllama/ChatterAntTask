package com.salesforce.chatter.authentication;

/**
 * ChatterData
 * @description Implementation of IChatterData for Ant Task
 */
public class ChatterData implements IChatterData {

	private final ChatterAuthMethod authMethod = ChatterAuthMethod.PASSWORD;
    
	//Default it to latest api version.
    private String apiVersion;
    private String instanceUrl;
    private String username;
    private String password;
    private String clientKey;
    private String clientSecret;
    
    public ChatterData(
    		String instanceUrl,
    		String apiVersion,
    		String username,
    		String password,
    		String clientKey,
    		String clientSecret){
    	this.instanceUrl = instanceUrl;
    	this.apiVersion = apiVersion;
    	this.username = username;
    	this.password = password;
    	this.clientKey = clientKey;
    	this.clientSecret = clientSecret;
    	if(this.apiVersion == null){
    		this.apiVersion = "29.0";
    	}
    }
    
    public String getApiVersion(){
    	return apiVersion;
    }
    
    public String getInstanceUrl() {
        return instanceUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ChatterAuthMethod getAuthMethod() {
        return authMethod;
    }

    public String getRefreshToken() {
        return null;
    }
    
    public String getClientKey() {
        return this.clientKey;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public String getClientCode() {
        return null;
    }

    public String getClientCallback() {
        return null;
    }
}