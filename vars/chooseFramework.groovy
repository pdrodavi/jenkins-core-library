def call() {

    inputFramework = input([
            message: 'Choose Framework',
            parameters: [
                    choice(name: 'Framework', choices: ['Spring', 'Quarkus'], description: 'Framework Stack to Pipeline')
            ]
    ])

    if ("${inputFramework}" == 'Spring') {
        println("Framework selecionado: ${inputFramework}")
    } else if ("${inputFramework}" == 'Quarkus') {
        println("Framework selecionado: ${inputFramework}")
    } else {
        println("Step Skipped")
    }

}
