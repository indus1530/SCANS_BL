package edu.aku.hassannaqvi.uen_midline.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract

class MainVModel : ViewModel() {

    var familyMemLst = MutableLiveData<MutableList<FamilyMembersContract>>()

    var mwraLst = MutableLiveData<MutableList<FamilyMembersContract>>()

    var childLstU5 = MutableLiveData<MutableList<FamilyMembersContract>>()

    fun setFamilyMembers(item: FamilyMembersContract) {
        var lst = familyMemLst.value
        if (lst.isNullOrEmpty())
            lst = mutableListOf()
        lst.add(item)
        familyMemLst.value = lst
    }

    fun setChildU5(item: FamilyMembersContract) {
        var lst = childLstU5.value
        if (lst.isNullOrEmpty())
            lst = mutableListOf()
        lst.add(item)
        childLstU5.value = lst
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

    fun getAllMenWomen(gender: Int): List<FamilyMembersContract>? {
        return familyMemLst.value?.filter { it -> it.age.toInt() > 15 && it.marital.toInt() != 2 && it.gender.toInt() == gender }
    }

    fun getAllMenWomenName(gender: Int): List<String>? {
        val family = familyMemLst.value?.filter { it -> it.age.toInt() > 15 && it.marital.toInt() != 2 && it.gender.toInt() == gender }
        return family?.map { it.name }
    }

    fun getAllMenWomenName02(gender: Int, serial: Int): Pair<List<Int>?, List<String>?> {
        val family = familyMemLst.value?.filter { it -> it.age.toInt() > 15 && it.marital.toInt() != 2 && it.gender.toInt() == gender }
        return Pair(family?.map { it.serialno.toInt() }?.filter { it != serial }, family?.map { it.name })
    }


}