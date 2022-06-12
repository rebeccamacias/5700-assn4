object Puzzle {
    private var size: Int = 0
    private var validSymbols: List<String> = listOf()
    var isSolved: Boolean = false
    var board: MutableList<MutableList<Cell>> = mutableListOf()

    fun getSize(): Int {
        return size
    }
    fun setSize(size: Int) {
        this.size = size
    }

    fun getValidSymbols(): List<String> {
        return validSymbols
    }

    fun setValidSymbols(validSymbols: List<String>) {
        this.validSymbols = validSymbols
    }

}