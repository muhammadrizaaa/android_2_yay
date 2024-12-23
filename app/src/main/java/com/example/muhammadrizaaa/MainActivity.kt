package com.example.muhammadrizaaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.FontScaling
import androidx.compose.ui.unit.dp
import com.example.muhammadrizaaa.ui.theme.MuhammadrizaaaTheme
import com.example.muhammadrizaaa.ui.theme.Purple80

class MainActivity : ComponentActivity() {

    fun pendosaList():ArrayList<Pendosa>{
        val pendosaList:ArrayList<Pendosa> = arrayListOf<Pendosa>()
        pendosaList.add(Pendosa("tes", 10, "haha"))
        pendosaList.add(Pendosa("Messi", 999999, "Rosasio Argentina"))
        return pendosaList
    }
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MuhammadrizaaaTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.primary
                        ),
                        title = ({ Text("Aplikasi List Pendosa") })
                    )
                },modifier = Modifier.fillMaxSize(), ) { innerPadding ->
                    listPendosa(modifier = Modifier.padding(innerPadding), pendosaList())
                }
            }
        }
    }
}
//@Composable
//fun topBar1(){
//}
@Composable
fun listPendosa(modifier: Modifier = Modifier, pendosa: ArrayList<Pendosa>){
    Column(modifier = modifier){
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)
        ) {
            Text(
                text = "List Pendosa",
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp),
                fontWeight = FontWeight.Bold
            )
            for (item in pendosa){
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.Gray),
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)
                ){
                    Column {
                        Text(
                            text = "Nama : " + item.name,
                            modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
                        )
                        Text(
                            text = "Dosa : " + item.dosa,
                            modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
                        )
                        Text(
                            text = "Alamat : " + item.alamat,
                            modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun addPendosa(){
    Row {

    }
}

data class Pendosa(val name: String, val dosa: Int, val alamat: String)