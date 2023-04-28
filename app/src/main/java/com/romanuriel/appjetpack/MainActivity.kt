package com.romanuriel.appjetpack

import android.content.Context
import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.romanuriel.appjetpack.ui.theme.AppJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val listTitle = listOf<String>("Rojo","Azul","Amarillo")
                    initialRecyclerView(list = listTitle)
                }
            }
        }
    }
}

data class Person(val name: String, val yield: Int)

data class ItemElement(val name: String, val image: Int)
@Composable
fun showDataPerson(person: Person) {
    Row{
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Aqui esta ",
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
                .border(1.2.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Text(text = "Nombre: ${person.name}!",
                color = MaterialTheme.colors.secondaryVariant)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Edad: ${person.yield}")
        }
    }
}

@Composable
fun initialRecyclerView(list: List<String>){
    LazyColumn{
        items(list){
            setElement(title = it)
        }
    }
}

@Composable
fun setElement(title: String){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp)

    ) {
        Card(
            modifier = Modifier
                .widthIn(max = 280.dp)
                .heightIn(min = 200.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Refrence image",
                    modifier = Modifier.size(120.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppJetpackTheme {
        //showDataPerson(person = Person("Roman", 22))
        setElement("Card")
    }
}


fun showMessage(message: Any, context: Context){
    val ms = when(message){
        is String ->{message}
        is Int ->{message.toString()}
        else -> {"Valor invalido"}
    }

    Toast.makeText(context, ms, Toast.LENGTH_SHORT).show()
}