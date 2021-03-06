// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package mxawsiot.actions;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import mxawsiot.impl.MqttConnector;

public class PublishMqttMessage extends CustomJavaAction<Boolean>
{
	private String BrokerHost;
	private Long BrokerPort;
	private String TopicName;
	private String Payload;
	private String CA;
	private String ClientCertificate;
	private String ClientKey;
	private String CertificatePassword;

	public PublishMqttMessage(IContext context, String BrokerHost, Long BrokerPort, String TopicName, String Payload, String CA, String ClientCertificate, String ClientKey, String CertificatePassword)
	{
		super(context);
		this.BrokerHost = BrokerHost;
		this.BrokerPort = BrokerPort;
		this.TopicName = TopicName;
		this.Payload = Payload;
		this.CA = CA;
		this.ClientCertificate = ClientCertificate;
		this.ClientKey = ClientKey;
		this.CertificatePassword = CertificatePassword;
	}

	@Override
	public Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
        MqttConnector connector = new MqttConnector();
        ILogNode logger = Core.getLogger(PublishMqttMessage.class.getName());
        logger.info("executeAction: topic: " + this.TopicName + ", message: " + this.Payload);
        try {
            connector.publish(
                    this.BrokerHost
                    , this.BrokerPort
                    , this.TopicName
                    , this.Payload
                    , this.CA
                    , this.ClientCertificate
                    , this.ClientKey
                    , this.CertificatePassword
            );
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
			return false;
        }
        return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "PublishMqttMessage";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
