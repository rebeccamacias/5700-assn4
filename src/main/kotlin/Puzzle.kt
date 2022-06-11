class Puzzle() {
    private var size: Int = 0
    private var validSymbols: List<String> = listOf()
    var board: MutableList<MutableList<String>> = mutableListOf()

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