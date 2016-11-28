import hudson.model.*

Hudson hudson = Hudson.getInstance()
hudson.setNumExecutors(25)
hudson.save()
