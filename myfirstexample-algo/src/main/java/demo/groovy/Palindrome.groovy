package demo.groovy

/**
 * Created by anya on 29/9/17.
 */
/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
 ***/
String.metaClass.isPalindrome = {->
    delegate == delegate.reverse()
}

word = 'tattarrattat'
println "$word is a palindrome? ${word.isPalindrome()}"
word = 'Groovy'
println "$word is a palindrome? ${word.isPalindrome()}"

lst = ['Groovy', 'is', 'hip']
println lst.join(' ')
println lst.getClass()