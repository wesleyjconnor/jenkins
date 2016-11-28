import jenkins.model.*

println "Adding an auto installer for Maven 3.3.9"

def mavenPluginExtension = Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0]

def asList = (mavenPluginExtension.installations as List)

// only add it once
if(asList.size < 1){
	asList.add(new hudson.tasks.Maven.MavenInstallation('maven-3', null, [new hudson.tools.InstallSourceProperty([new hudson.tasks.Maven.MavenInstaller("3.3.9")])]))

	mavenPluginExtension.installations = asList

	mavenPluginExtension.save()

	println "added maven installer"

}
