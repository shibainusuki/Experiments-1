package com.example.experiments

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.experiments.aroundlambda.Closure
import com.example.experiments.aroundlambda.FunctionAsObject
import com.example.experiments.aroundlambda.Lambda
import com.example.experiments.dataclass.DataClass
import com.example.experiments.extendedfunction.ExtendedFunction
import com.example.experiments.ui.theme.ExperimentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExperimentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        FunctionAsObject.main()
        FunctionAsObject.showCalculateResult()
        val closure = Closure()
        closure.closureMain()
        closure.likeClosureMain()
        closure.closureMain2()

        val lambda = Lambda()
        lambda.lambdaMain()

        ExtendedFunction().main()

        //Dada Classの挙動確認
        DataClass().showDataClassBehavior()
        DataClass().showNormalClassBehavior()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExperimentsTheme {
        HelloScreen()
    }
}


@Composable
fun HelloScreen() {
    var name by rememberSaveable { mutableStateOf("タロウ") }
    Log.d("テスト","name is: $name")

    HelloContent(name = name, onNameChange = { name = it })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}