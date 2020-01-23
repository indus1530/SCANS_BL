package edu.aku.hassannaqvi.uen_midline.ui.list_activity

import android.content.Intent
import android.os.Bundle
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
import edu.aku.hassannaqvi.uen_midline.ui.sections.SectionDActivity
import edu.aku.hassannaqvi.uen_midline.ui.sections.SectionE1Activity
import edu.aku.hassannaqvi.uen_midline.ui.sections.SectionE3Activity
import edu.aku.hassannaqvi.uen_midline.utils.Util
import edu.aku.hassannaqvi.uen_midline.viewmodel.MainVModel
import kotlinx.android.synthetic.main.activity_family_members_list.*
import kotlinx.android.synthetic.main.item_mem_list.view.*
import ru.whalemare.sheetmenu.ActionItem
import ru.whalemare.sheetmenu.SheetMenu
import ru.whalemare.sheetmenu.layout.GridLayoutProvider

class FamilyMembersListActivity : AppCompatActivity() {

    //    private lateinit var mainVModel: MainVModel
    private var serial = 0
    private var memSelectedCounter = 0
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
                                    if (memSelectedCounter != serial) return@run

                                    MainApp.pragnantWoman = mainVModel.getAllWomenName()

                                    startActivity(Intent(this, if (bi.contentScroll.mwra.text.toString().toInt() > 0) SectionE1Activity::class.java else SectionE3Activity::class.java))
                                }
                                else -> Util.openEndActivity(this)
                            }
                        }

                    }, layoutProvider = GridLayoutProvider()
            ).show(this)

        }
        toolbar_layout.title = "Household FamilyMembers"
        toolbar_layout.setExpandedTitleTextAppearance(R.style.expandCollapse)
    }

    private fun settingValue() {
        setupRecyclerView(mutableListOf())
        mainVModel = this.run {
            ViewModelProviders.of(this)[MainVModel::class.java]
        }
        mainVModel.childLstU5.observe(this, Observer { item -> bi.contentScroll.under5.text = String.format("%02d", item.size) })
        mainVModel.mwraLst.observe(this, Observer { item -> bi.contentScroll.mwra.text = String.format("%02d", item.size) })
        mainVModel.familyMemLst.observe(this, Observer { item ->
            bi.contentScroll.total.text = String.format("%02d", item.size)
            adapter.setMList(item)
        })
    }

    private fun setupRecyclerView(membersLst: MutableList<FamilyMembersContract>) {
        adapter = ChildListAdapter(this, membersLst)
        bi.contentScroll.recyclerView.layoutManager = LinearLayoutManager(this)
        bi.contentScroll.recyclerView.adapter = adapter
        adapter.setItemClicked { item, position, holder ->
            openDialog(this, item)
            MainApp.setItemClick {

                memSelectedCounter++

                holder.parentLayout.isEnabled = false
                holder.parentLayout.checkIcon.visibility = View.VISIBLE

                startActivityForResult(Intent(this, SectionDActivity::class.java)
                        .putExtra(SERIAL_EXTRA, item.serialno.toInt()), CONSTANTS.MEMBER_ITEM)

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
        lateinit var mainVModel: MainVModel
    }
}
