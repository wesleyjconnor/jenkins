import java.util.Collections;
import jenkins.model.*
import org.jenkinsci.lib.configprovider.model.Config
import org.jenkinsci.plugins.configfiles.maven.security.ServerCredentialMapping;
import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import hudson.util.Secret;
import org.jenkinsci.plugins.configfiles.maven.GlobalMavenSettingsConfig;


String id = "settings-xml-global"
String name = "custom-global-settings.xml"
String desc = "custom-global-settings.xml"

String content = """
<settings>
    
</settings>
"""

GlobalMavenSettingsConfig config = new GlobalMavenSettingsConfig(id,name,desc,content,GlobalMavenSettingsConfig.isReplaceAllDefault, new java.util.ArrayList<ServerCredentialMapping>())

org.jenkinsci.lib.configprovider.ConfigProvider provider = Jenkins.instance.getExtensionList('org.jenkinsci.lib.configprovider.ConfigProvider')[0];

if(provider.configExists(id))
{
  	println "global settings.xml already added"
}else{
  	provider.save(config)
	println "added global settings.xml"
}
