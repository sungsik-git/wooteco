package evnet

class BadgeEvent {
    companion object {
        const val MINIMUM_DISCOUNT = 5000
        const val MIDDLE_DISCOUNT = 10000
        const val MAXIMUM_DISCOUNT = 20000
    }

    fun applyBadgeEvent(discount: Int): String {
        var badge = when {
            discount in MINIMUM_DISCOUNT..<MIDDLE_DISCOUNT -> "별"
            discount in MIDDLE_DISCOUNT..<MAXIMUM_DISCOUNT -> "트리"
            MAXIMUM_DISCOUNT <= discount -> "산타"
            else -> "없음"
        }
        return badge
    }

}