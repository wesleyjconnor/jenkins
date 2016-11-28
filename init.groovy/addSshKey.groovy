import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*

String username = ""

String key = """-----BEGIN RSA PRIVATE KEY-----
-----END RSA PRIVATE KEY-----
"""


String keyId = "my-id"
String description = "deploy key"
credentials = new com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey(CredentialsScope.GLOBAL,keyId,username,new com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey.DirectEntryPrivateKeySource(key),"",description)

store = Jenkins.getInstance().getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()
store.addCredentials(Domain.global(), credentials)

println "Added git credentials"
