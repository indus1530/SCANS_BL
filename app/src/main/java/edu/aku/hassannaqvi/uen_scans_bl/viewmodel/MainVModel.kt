package edu.aku.hassannaqvi.uen_scans_bl.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FamilyMembersContract

class MainVModel : ViewModel() {

    var familyMemLst = MutableLiveData<MutableList<FamilyMembersContract>>()
        private set

    var mwraLst = MutableLiveData<MutableList<FamilyMembersContract>>()
        private set

    var childLstU5to10 = MutableLiveData<MutableList<FamilyMembersContract>>()
        private set

    var mwraChildU5to10Lst = MutableLiveData<MutableList<FamilyMembersContract>>()
        private set

    var checkedItems = MutableLiveData<MutableList<Int>>()
        private set

    fun setFamilyMembers(item: FamilyMembersContract) {
        var lst = familyMemLst.value
        if (lst.isNullOrEmpty())
            lst = mutableListOf()
        lst.add(item)
        familyMemLst.value = lst
    }

    fun updateFamilyMembers(item: FamilyMembersContract) {
        val lst = familyMemLst.value
        lst?.map { if (it.serialno.toInt() == item.serialno.toInt()) item else it }
        familyMemLst.value = lst
    }

    fun setChildU5to10(item: FamilyMembersContract) {
        var lst = childLstU5to10.value
        if (lst.isNullOrEmpty())
            lst = mutableListOf()
        lst.add(item)
        childLstU5to10.value = lst
    }

    fun setMwraChildU5to10(item: FamilyMembersContract) {
        var lst = mwraChildU5to10Lst.value
        if (lst.isNullOrEmpty()) {
            lst = mutableListOf()
            lst.add(item)
        } else {
            val fmc = mwraChildU5to10Lst.value?.find { it.serialno.toInt() == item.serialno.toInt() }
            fmc?.let { lst.map { if (it.serialno.toInt() == fmc.serialno.toInt()) item else it } }
                    ?: lst.add(item)
        }
        mwraChildU5to10Lst.value = lst
    }

    fun setCheckedItemValues(index: Int) {
        var lst = checkedItems.value
        if (lst.isNullOrEmpty()) {
            lst = mutableListOf()
            lst.add(index)
        } else lst.add(index)

        checkedItems.value = lst
    }

    fun setMWRA(item: FamilyMembersContract) {
        var lst = mwraLst.value
        if (lst.isNullOrEmpty())
            lst = mutableListOf()
        lst.add(item)
        mwraLst.value = lst
    }

    fun getMemberInfo(index: Int): FamilyMembersContract? {
        return familyMemLst.value?.find { it.serialno.toInt() == index }
    }

    fun getAllMenWomenName(gender: Int, currentPersonSerial: Int): Pair<List<Int>?, List<String>?> {
        val family = familyMemLst.value?.filter { it -> it.age.toInt() >= 15 && it.marital.toInt() != 2 && it.gender.toInt() == gender }
        return Pair(family?.map { it.serialno.toInt() }?.filter { it != currentPersonSerial }, family?.map { it.name })
    }

    fun getAllChildrenOfSelMWRA(mwraSerial: Int): List<FamilyMembersContract>? {
        return childLstU5to10.value?.filter { it -> it.mother_serial.toInt() == mwraSerial }
    }

    /* fun getAllWomenName(): Pair<List<Int>?, List<String>?> {
         val family = familyMemLst.value?.filter { it -> (it.age.toInt() in 15..50) && it.marital.toInt() != 2 && it.gender.toInt() == 2 }
         return Pair(family?.map { it.serialno.toInt() }, family?.map { it.name })
     }*/

    fun getAllChildrenPairOfSelMWRA(mwraSerial: Int): Pair<List<Int>?, List<String>?> {
        val family = childLstU5to10.value?.filter { it -> it.mother_serial.toInt() == mwraSerial }
        return Pair(family?.map { it.serialno.toInt() }, family?.map { it.name })
    }

    fun getAllUnder5(): Pair<List<Int>?, List<String>?> {
        val family = familyMemLst.value?.filter { it -> (it.age.toInt() < 5) }
        return Pair(family?.map { it.serialno.toInt() }, family?.map { it.name })
    }

    fun getAllRespondent(): Pair<List<Int>?, List<String>?> {
        val family = familyMemLst.value?.filter { it -> (it.age.toInt() >= 15) }
        return Pair(family?.map { it.serialno.toInt() }, family?.map { it.name })
    }

    fun getCheckedItemValues(fmItem: Int): Boolean {
        val flag = checkedItems.value?.find { it == fmItem }
        flag?.let { return true } ?: return false
    }


}