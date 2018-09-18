import groovy.transform.SourceURI
import jenkins.model.Jenkins

@SourceURI URI sourceUri
def initializationFile = new File(sourceUri.getPath() + ".run")
def isInitialized = initializationFile.exists()

def forceInitialization = System.getenv("JENKINS_FORCE_INITIALIZATION")

if (forceInitialization || !isInitialized){
    def instance = Jenkins.getInstance()

    instance.getDescriptor("jenkins.CLI").get().setEnabled(false)
 
    instance.save()

}

initializationFile.createNewFile()
