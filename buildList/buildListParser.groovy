def failedMap = [:]
def successList = []
def buildNumList = []

File file = new File(args[0])
file.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        if (line.contains('FAILED')) {
            def key = line.split(' ')[1]

            if (failedMap.containsKey(key)) {
                buildNumList = failedMap.get(key)
                buildNumList.add(line.split(' ')[0])
            } else {
                buildNumList = ["${line.split(' ')[0]}"]
                failedMap.put(key, buildNumList)
            }
        } else {
            successList.add(line.split(' ')[1])
        }
    }
}

failedMap.each { buildName ->
    buildName.value.sort()
    def consecutiveFailFinal = 1
    def consecutiveFailTmp = 1
    for (i = 0; i < buildName.value.size(); i++){
        if (i != 0 && buildName.value[i].toInteger() == buildName.value[i-1].toInteger()+1){
            consecutiveFailTmp++
            consecutiveFailFinal = (consecutiveFailTmp > consecutiveFailFinal) ? consecutiveFailTmp : consecutiveFailFinal
        } else {
            consecutiveFailFinal = (consecutiveFailTmp > consecutiveFailFinal) ? consecutiveFailTmp : consecutiveFailFinal
            consecutiveFailTmp = 1
        }
    }
    println "${buildName.key}'s most consecutive failures: ${consecutiveFailFinal}"
    successList.removeAll(buildName.key)
}

successList.each { buildName ->
    println "${buildName}'s most consecutive failures: 0"
}