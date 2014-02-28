package com.salesforce.chatter.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import com.salesforce.chatter.ChatterService;
import com.salesforce.chatter.authentication.ChatterData;
import com.salesforce.chatter.commands.PostToGroupCommand;
import com.salesforce.chatter.commands.ChatterCommand;
import com.salesforce.chatter.message.Message;
import com.salesforce.chatter.message.TextSegment;

/**
 * ChatterTask
 * @description Ant Task for sending a chatter message.
 * @author James Loghry
 */
public class ChatterTask extends Task {
	
	private String instanceUrl;
	private String apiVersion;
	private String username;
	private String password;
	private String groupId;
	private String message;
	private String clientSecret;
	private String clientKey;
	
	public void execute() {
		try{
			Message msg = new Message();
			msg.addSegment(new TextSegment(message));
		
			ChatterCommand cmd = new PostToGroupCommand(groupId);
			ChatterService service = new ChatterService(new ChatterData(instanceUrl,apiVersion,username,password,clientKey,clientSecret));
			service.executeCommand(cmd, msg);
		}catch(Exception e){
			 throw new BuildException(e);
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getInstanceUrl() {
		return instanceUrl;
	}

	public void setInstanceUrl(String instanceUrl) {
		this.instanceUrl = instanceUrl;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
}
