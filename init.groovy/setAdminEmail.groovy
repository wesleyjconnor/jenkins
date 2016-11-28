import jenkins.model.*

def instance = Jenkins.getInstance()

def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()

jenkinsLocationConfiguration.setAdminAddress("here@there.com")
jenkinsLocationConfiguration.setUrl("http://")
jenkinsLocationConfiguration.save()

instance.save()
