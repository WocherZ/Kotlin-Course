import kotlin.reflect.full.memberProperties


class MyCustomClass(val index: Int, val name: String)

fun isDigit(str: String): Boolean {
    return try {
        val v = str.toInt()
        true
    } catch (ex: java.lang.Exception) {
        false
    }
}


fun checkJsonToClass(classProperties: List<String>,
                     classPropertiesNames: List<String>,
                     json: Map<String, String>): Boolean {


    val jsonKeys = json.keys.toMutableList()
    val jsonValues = json.values.toMutableList()
    if (classProperties.size == jsonKeys.size) {

        for (i in classProperties.indices) {

            if (classPropertiesNames[i].toString() == jsonKeys[i].toString()) {
                if (!isDigit(jsonValues[i]) && classProperties[i] == Int::class.toString()) { return false }
                if (isDigit(jsonValues[i]) && classProperties[i] == String::class.toString()) { return false }

            } else { return false }

        }

    } else { return false }
    return true
}

fun main() {
    // {'index': 5, 'name': "Abraham"}
    val json = mapOf("indexes" to "6", "name" to "Abraham")

    val classPropertiesTypes = ArrayList<String>()
    val classPropertiesNames = ArrayList<String>()
    for (member in MyCustomClass::class.memberProperties) {
        classPropertiesTypes.add(member.returnType.classifier.toString())
        classPropertiesNames.add(member.name.toString())
    }

    println(checkJsonToClass(classPropertiesTypes, classPropertiesNames, json))
}