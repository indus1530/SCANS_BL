package edu.aku.hassannaqvi.uen_midline.ui.list_activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import edu.aku.hassannaqvi.uen_midline.CONSTANTS
import edu.aku.hassannaqvi.uen_midline.CONSTANTS.Companion.SERIAL_EXTRA
import edu.aku.hassannaqvi.uen_midline.R
import edu.aku.hassannaqvi.uen_midline.adapter.ChildListAdapter
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract
import edu.aku.hassannaqvi.uen_midline.core.MainApp
import edu.aku.hassannaqvi.uen_midline.core.MainApp.openDialog
import edu.aku.hassannaqvi.uen_midline.databinding.ActivityFamilyMembersListBinding
import edu.aku.hassannaqvi.uen_midline.ui.other.EndingActivity
import edu.aku.hassannaqvi.uen_midline.ui.sections.SectionDActivity
import edu.aku.hassannaqvi.uen_midline.ui.sections.SectionE1Activity
import edu.aku.hassannaqvi.uen_midline.viewmodel.MainVModel
import kotlinx.android.synthetic.main.activity_family_members_list.*
import kotlinx.android.synthetic.main.item_mem_list.view.*
import ru.whalemare.sheetmenu.ActionItem
import ru.whalemare.sheetmenu.SheetMenu
import ru.whalemare.sheetmenu.layout.GridLayoutProvider

class FamilyMembersListActivity : AppCompatActivity() {

    //    private lateinit var mainVModel: MainVModel
    private var serial = 0
    private lateinit var adapter: ChildListAdapter
    private lateinit var bi: ActivityFamilyMembersListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_members_list)
        setSupportActionBar(toolbar)

        bi = DataBindingUtil.setContentView(this, R.layout.activity_family_members_list)
        bi.callback = this

        settingValue()
        settingMenu()
    }

    private fun settingMenu() {

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
                                    serial++
                                    startActivityForResult(Intent(this, SectionDActivity::class.java).putExtra(SERIAL_EXTRA, serial), CONSTANTS.MEMBER_ITEM)
                                }
                                1 -> {
                                    startActivity(Intent(this, SectionE1Activity::class.java))
                                }
                                else -> startActivity(Intent(this, EndingActivity::class.java)
                                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                )
                            }
                        }

                    }, layoutProvider = GridLayoutProvider()
            ).show(this)

        }
        toolbar_layout.title = "Household FamilyMembers"
        toolbar_layout.setExpandedTitleTextAppearance(R.style.expandCollapse)
    }

    private fun settingValue() {
        context = this
        setupRecyclerView(mutableListOf())

        mainVModel = this.run {
            ViewModelProviders.of(this)[MainVModel::class.java]
        }
        mainVModel.childLstU5.observe(this, Observer { item -> Log.d("", item.size.toString()) })
        mainVModel.mwraLst.observe(this, Observer { item -> Log.d("", item.size.toString()) })
        mainVModel.familyMemLst.observe(this, Observer { item ->
            setupRecyclerView(item)
        })
    }

    fun setupRecyclerView(membersLst: MutableList<FamilyMembersContract>) {
        adapter = ChildListAdapter(this, membersLst)
        bi.contentScroll.recyclerView.layoutManager = LinearLayoutManager(this)
        bi.contentScroll.recyclerView.adapter = adapter
        adapter.setItemClicked { item, position ->
            openDialog(this, item)
            MainApp.setItemClick {

                adapter.holder.parentLayout.isEnabled = false
                adapter.holder.parentLayout.checkIcon.visibility = View.VISIBLE

                startActivityForResult(Intent(this, SectionDActivity::class.java).putExtra(SERIAL_EXTRA, serial), CONSTANTS.MEMBER_ITEM)

            }

        }

    }

/*    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CONSTANTS.MEMBER_ITEM) {
            if (resultCode == Activity.RESULT_OK)
                adapter.notifyDataSetChanged()
        }
    }*/

    companion object {
        var context: FamilyMembersListActivity? = null
        lateinit var mainVModel: MainVModel
    }
}
