package com.aggreyah.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.aggreyah.notekeeper.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

//        val navController = findNavContro ller(R.id.nav_host_fragment_content_note_list)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        this.findViewById<ListView>(R.id.listNotes).adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, DataManager.notes)

        this.findViewById<ListView>(R.id.listNotes).setOnItemClickListener{parent, view, position, id
            ->
            val activityIntent = Intent(this, MainActivity::class.java)
            activityIntent.putExtra(NOTE_POSITION, position)
            startActivity(activityIntent)
        }


    }

    override fun onResume() {
        super.onResume()
        (this.findViewById<ListView>(R.id.listNotes).adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }
}