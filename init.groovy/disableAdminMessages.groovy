import jenkins.model.*
import java.util.logging.Logger

def instance = Jenkins.getInstance()

for(def i : instance.administrativeMonitors)
{
  	//println(i.getDisplayName())
	//println(i.getUrl())
}

def security = instance.getAdministrativeMonitor("jenkins.diagnostics.SecurityIsOffMonitor")
security.disable(true)

def oldData = instance.getAdministrativeMonitor("OldData")
oldData.disable(true)

def proxy = instance.getAdministrativeMonitor("hudson.diagnosis.ReverseProxySetupMonitor")
proxy.disable(true)


instance.save()
