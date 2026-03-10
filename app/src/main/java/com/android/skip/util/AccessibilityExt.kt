package com.android.skip.util

import android.view.accessibility.AccessibilityEvent
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

const val STATE_CHANGED = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
const val CONTENT_CHANGED = AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED

private const val interestedEvents = STATE_CHANGED or CONTENT_CHANGED
@OptIn(ExperimentalContracts::class)
fun AccessibilityEvent?.isUseful(): Boolean {
    contract {
        returns(true) implies (this@isUseful != null)
    }
    return (this != null && packageName != null && className != null && eventType and interestedEvents != 0)
}