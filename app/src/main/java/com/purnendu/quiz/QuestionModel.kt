package com.purnendu.quiz

data class QuestionModel(
    val question: String,
    val answer: String
) {
    companion object {
        val list = arrayListOf(
            QuestionModel("What is actually electricity?", "A flow of electrons"),
            QuestionModel("What is the main component of the sun?", "Gas"),
            QuestionModel("Capital of India", "Delhi"),
            QuestionModel("Which of the following animals can run the fastest?", "Cheetah"),
            QuestionModel("Capital  of WestBengal", "Kolkata")
        )


        val ans1ButtonList = arrayListOf("A flow of light", "Liquid lava", "Karnataka","Cheetah", "Darjeeling")
        val ans2ButtonList = arrayListOf("A flow of water", "Gas", "Assam","Leopard", "Haldia")
        val ans3ButtonList = arrayListOf("A flow of electrons", "Molten iron", "Delhi","Tiger", "Kolkata")
        val ans4ButtonList = arrayListOf("A flow of atoms", "Rock", "Goa","Lion", "Durgapur")
    }
}
