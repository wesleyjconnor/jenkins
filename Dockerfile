FROM jenkins:2.19.3

USER root

ENV TZ=Europe/Berlin
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
#RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/plugins.txt

RUN install-plugins.sh ace-editor analysis-core ant antisamy-markup-formatter bouncycastle-api branch-api build-timeout cloudbees-folder config-file-provider credentials credentials-binding display-url-api durable-task email-ext external-monitor-job git git-client github github-api github-branch-source github-organization-folder git-server gradle handlebars icon-shim jquery-detached junit job-dsl ldap mailer mapdb-api matrix-auth matrix-project momentjs pam-auth pipeline-build-step pipeline-graph-analysis pipeline-input-step pipeline-milestone-step pipeline-rest-api pipeline-stage-step pipeline-stage-view plain-credentials scm-api script-security ssh-credentials ssh-slaves structs subversion timestamper token-macro windows-slaves workflow-aggregator workflow-api workflow-basic-steps workflow-cps workflow-cps-global-lib workflow-durable-task-step workflow-job workflow-multibranch workflow-scm-step workflow-step-api workflow-support ws-cleanup progress-bar-column-plugin javadoc ssh

COPY init.groovy/*.groovy /usr/share/jenkins/ref/init.groovy.d/


#override the plugin installation window (doesnt work)
RUN echo 2.0 > /var/jenkins_home/jenkins.install.UpgradeWizard.state

#clean up after apt
RUN apt-get update && apt-get install vim -y && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

ADD config /var/jenkins_home/


#USER jenkins
#CMD ["java", "-jar", "/jenkins/jenkins.war", "--httpPort=8080", "--ajp13Port=8009"]

#docker stop myjenkins || true && sudo docker rm myjenkins || true && \
#docker run --name jenkins -p 8080:8080 -p 50000:50000 --env JAVA_OPTS=-DargumentsRealm.passwd=pass-Dhudson.footerURL=http://mycompany.com jenkins

#find jenkins pw
#docker exec jenkins-master cat /var/jenkins_home/secrets/initialAdminPassword

#docker run -e JENKINS_JAVA_OPTIONS="-Duser.timezone=America/New_York -Dhudson.model.DirectoryBrowserSupport.CSP= " --name jenkins_master -d -p 80:8080 -v /home/user/jenkins/:/var/lib/jenkins -v /home/user/jenkins/timezone:/etc/timezone jenkins