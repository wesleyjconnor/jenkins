import jenkins.model.*

Jenkins j = Jenkins.getInstance();
def view = j.getView("builds")
if(view != null) {
	j.setPrimaryView(view);
	println "Set builds as default view"
}else{
	println "Builds view not found"
}
