import jenkins.model.*

def instance = Jenkins.getInstance()

def mailer = instance.getDescriptor("hudson.tasks.Mailer")

mailer.setSmtpAuth("here@there.com", "password")
mailer.setReplyToAddress("no-reply@there.com")
mailer.setSmtpHost("smtp.gmail.com")
mailer.setUseSsl(true)
mailer.setSmtpPort("465")
mailer.setCharset("UTF-8")

mailer.save()

instance.save()
