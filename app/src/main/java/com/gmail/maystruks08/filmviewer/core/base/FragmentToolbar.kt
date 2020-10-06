package com.gmail.maystruks08.filmviewer.core.base

import android.text.InputType
import android.view.MenuItem
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes

class FragmentToolbar(
    @IdRes val resId: Int,
    @StringRes val title: Int,
    @MenuRes val menuId: Int,
    @DrawableRes val navigationIcon: Int,
    val navigationIconClickListener: (() -> Unit)?,
    val searchViewTextChangeListener: ((String) -> Unit)?,
    val searchViewInputType: Int,
    val menuItems: MutableList<Int>,
    val menuClicks: MutableList<MenuItem.OnMenuItemClickListener?>
) {
    class Builder {
        private var resId: Int = NO_TOOLBAR
        private var menuId: Int = NO_TOOLBAR
        private var title: Int = NO_TOOLBAR
        private var navigationIcon: Int = NO_TOOLBAR
        private var navigationIconClickListener: (() -> Unit)? = null
        private var menuItems: MutableList<Int> = mutableListOf()
        private var menuClicks: MutableList<MenuItem.OnMenuItemClickListener?> = mutableListOf()
        private var searchViewTextChangeListener: ((String) -> Unit)? = null
        private var searchViewInputType: Int = InputType.TYPE_CLASS_TEXT

        fun withId(@IdRes resId: Int) = apply { this.resId = resId }

        fun withTitle(title: Int) = apply { this.title = title }

        fun withNavigationIcon(@DrawableRes navigationIconId: Int, navigationIconClickListener: () -> Unit) =
            apply {
                this.navigationIcon = navigationIconId
                this.navigationIconClickListener = navigationIconClickListener
            }

        fun withMenu(@MenuRes menuId: Int) = apply { this.menuId = menuId }

        fun withMenuSearch(inputType: Int = InputType.TYPE_CLASS_TEXT, searchViewTextChangeListener: (String) -> Unit) =
            apply {
                this.searchViewTextChangeListener = searchViewTextChangeListener
                this.searchViewInputType = inputType
            }

        fun withMenuItems(
            menuItems: List<Int>,
            menuClicks: List<MenuItem.OnMenuItemClickListener?>
        ) = apply {
            this.menuItems.addAll(menuItems)
            this.menuClicks.addAll(menuClicks)
        }

        fun build() = FragmentToolbar(
            resId,
            title,
            menuId,
            navigationIcon,
            navigationIconClickListener,
            searchViewTextChangeListener,
            searchViewInputType,
            menuItems,
            menuClicks
        )
    }

    companion object {
        const val NO_TOOLBAR = -1
    }
}