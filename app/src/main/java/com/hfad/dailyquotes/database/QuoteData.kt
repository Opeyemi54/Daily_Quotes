
package com.hfad.dailyquotes.database

import com.hfad.dailyquotes.model.QuoteCategory
import com.hfad.dailyquotes.model.Quotedataclass

fun getPrePopulatedData(): List<Quotedataclass> {
    return listOf(
        Quotedataclass(1,"Life is what happens when you are busy making other plans", "John Lennon", false, QuoteCategory.Life.name),
        Quotedataclass(2,"Twenty years from now, you will be more disappointed by the things that you didn't do than by the ones you did do.", "Mark Twain",false, QuoteCategory.Life.name),
        Quotedataclass(3,"The only person you are destined to become is the person you decide to be.", "Ralph Waldo",false, QuoteCategory.Life.name),
        Quotedataclass(4,"The purpose of life is not to be happy., It is to be useful, to be honorable, to be compassionate, to have it make some difference that you have lived and lived well.", "Ralph Waldo",false, QuoteCategory.Life.name),

        Quotedataclass(5,"To love and to be loved is to feel the sun from both sides.", "David Viscott", false, QuoteCategory.Love.name),
        Quotedataclass(6,"You may not always be together but you will never be apart. For the greatest thing you will ever learn is to love and be loved in return.", "Moulin Rouge",false, QuoteCategory.Love.name),
        Quotedataclass(7,"Love is not about finding someone to complete you; it's about finding someone who accepts you completely.", "Roy croft",false, QuoteCategory.Love.name),
        Quotedataclass(8,"A successful marriage requires falling in love many times, always with the same person.", "Mignon McLaughlin", false, QuoteCategory.Love.name),

        Quotedataclass(9,"I wasn't there to compete, I was there to win.", "Arnold Schwarzenegger",false, QuoteCategory.Motivation.name),
        Quotedataclass(10,"Someone once told me growth and comfort do not coexist.", "Ginni Rometty", false, QuoteCategory.Motivation.name),
        Quotedataclass(11,"It's not about how many times you fall that cunts. It's about how many times you get back up.", "Nelson Mandela",false, QuoteCategory.Motivation.name),
        Quotedataclass(12,"The difference between ordinary and extraordinary is that little extra.", "Jimmy Johnson",false, QuoteCategory.Motivation.name),

        Quotedataclass(13,"Success is stumbling from failure to failure with no loss of enthusiasm.", "Winston Churchill",false, QuoteCategory.Success.name),
        Quotedataclass(14,"The only way to do great work is to love what you do. if you haven't found it yet, keep looking.", "Steve Jobs",false, QuoteCategory.Success.name),
        Quotedataclass(15,"There are three ways to ultimate success: First, be kind. Second, be kind. Third, be kind.", "Henry James",false, QuoteCategory.Success.name),
        Quotedataclass(16,"Don't be afraid to give up the good to go for the great.", "John D. Rockefeller",false, QuoteCategory.Success.name),

        Quotedataclass(17, "I'm so tired of feeling tired.", "Unknown", false, QuoteCategory.Tired.name),
        Quotedataclass(18, "Fatigue is the best pillow.", "Benjamin Franklin", false, QuoteCategory.Tired.name),
        Quotedataclass(19, "Tired minds don't plan well. sleep first, plan later.", "Walter Reisch", false, QuoteCategory.Tired.name),
        Quotedataclass(20, "The best bridge between despair and hope is a good sleep.", "E.Joseph Cossman", false, QuoteCategory.Tired.name),

        Quotedataclass(21, "The walls we build around us to keep sadness out also keeps out the joy.", "Jim Rohn", false, QuoteCategory.Sad.name),
        Quotedataclass(22, "Every man has his secret sorrows which the world knows not; and often times we call a man cold when he is only sad.", "Henry WadsWorth LongFellow", false, QuoteCategory.Sad.name),
        Quotedataclass(23, "Tears comes from the heart not from the brain.", "Leonardo da Vinci", false, QuoteCategory.Sad.name),
        Quotedataclass(24, "The good times of today are the sad thoughts of tomorrow.", "Bob Marley", false,  QuoteCategory.Sad.name),

        Quotedataclass(25, "I'm not arguing, I'm just explaining why I'm right.", "Unknown", false, QuoteCategory.Funny.name),
        Quotedataclass(26, "I used to think i was indecisive, but now I'm not so sure .", "Unknown", false, QuoteCategory.Funny.name),
        Quotedataclass(27, "I'm so clever that sometimes i don't understand a single.word of what i'm saying", "Oscar Wilde", false, QuoteCategory.Funny.name),
        Quotedataclass(28, "I always wanted to be somebody, but now i realize i should have been more specific.", "Lilly Tomlin", false, QuoteCategory.Funny.name),

        Quotedataclass(29, "Anger is never without a reason, but seldom with a good one.", "Benjamin Franklin", false,  QuoteCategory.Angry.name),
        Quotedataclass(30, "Never go to bed mad. Stay up and fight.", "Phyllis Diller", false, QuoteCategory.Angry.name),
        Quotedataclass(31, "For every minute you remain angry, you give up sixty seconds of peace of mind.", "Ralph Waldo Emerson", false, QuoteCategory.Angry.name),
        Quotedataclass(32, "Speak when you are angry and you will make the best speech you will ever regret.", "Ambrose Bierce", false, QuoteCategory.Angry.name),

        Quotedataclass(33,"Curiosity is the very first of the inventions of a child's genius.", "Geoffrey Chaucer", false, QuoteCategory.English.name),
        Quotedataclass(34,"A dream you don't chase remains a dream. A goal you don't chase set remains a wish. A chance you don't take remains a regret", "Lewis Carroll",false, QuoteCategory.English.name),
        Quotedataclass(35,"It is not the mountain we conquer, but ourselves.", "Edmund Hillary",false, QuoteCategory.English.name),
        Quotedataclass(36,"I am not afraid of tomorrow, for i have learned from yesterday.", "Jane Austen",false, QuoteCategory.English.name),

        Quotedataclass(37,"Happiness is not something ready-made. it comes from your actions.", "Dalai Lama", false, QuoteCategory.Happy.name),
        Quotedataclass(38,"Happiness is when what you think, what you say , and what you do are in harmony.", "Mahatma Gandhi",false,  QuoteCategory.Happy.name),
        Quotedataclass(39,"For every minutes you are angry you loose sixty seconds of happiness.", "Walder Emerson",false, QuoteCategory.Happy.name),
        Quotedataclass(40,"The purpose of our lives is to be happy.", "Dalai Lama",false, QuoteCategory.Happy.name)

    )

}