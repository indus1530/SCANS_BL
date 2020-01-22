package edu.aku.hassannaqvi.uen_midline

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_family_members_list.*
import ru.whalemare.sheetmenu.ActionItem
import ru.whalemare.sheetmenu.SheetMenu
import ru.whalemare.sheetmenu.layout.GridLayoutProvider

class FamilyMembersListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_members_list)
        setSupportActionBar(toolbar)
        fabMenu.setOnClickListener {
            SheetMenu(
                    "Select your Action",
                    listOf(
                            ActionItem(
                                    0,
                                    "Add Member",
                                    getDrawable(R.drawable.ic_account_circle_black_24dp)
                            )
                            ,
                            ActionItem(
                                    1,
                                    "Next Section",
                                    getDrawable(R.drawable.ic_keyboard_arrow_right_black_24dp)
                            )
                            ,
                            ActionItem(
                                    2,
                                    "End Activity",
                                    getDrawable(R.drawable.ic_closed_caption_black_24dp)
                            )
                    ),
                    onClick = { item: ActionItem ->
                        run {
                            when (item.id) {
                                0 -> {
                                    Toast.makeText(this, "abcd", Toast.LENGTH_SHORT)
                                            .show()
                                }
                                1 -> {
                                    Toast.makeText(this, "fagga", Toast.LENGTH_SHORT)
                                            .show()
                                }
                                else -> finish()
                            }
                        }

                    }, layoutProvider = GridLayoutProvider()
            ).show(this)

        }

        toolbar_layout.title = "Household FamilyMembers"
        toolbar_layout.setExpandedTitleTextAppearance(R.style.expandCollapse)
    }
}
