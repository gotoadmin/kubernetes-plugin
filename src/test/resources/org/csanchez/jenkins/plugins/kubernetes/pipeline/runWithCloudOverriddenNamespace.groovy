podTemplate(volumes: [emptyDirVolume(mountPath: '/my-mount')], containers: [
        containerTemplate(name: 'jnlp', image: 'jenkins/jnlp-slave:3.10-1-alpine', args: '${computer.jnlpmac} ${computer.name}')
]) {

    node(POD_LABEL) {
        container(name: 'jnlp') {
            sh "cat /var/run/secrets/kubernetes.io/serviceaccount/namespace"
        }
    }
}
