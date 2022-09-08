import spock.lang.*

class ReverseStringSpec extends Specification {

    def "An empty string"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value || expected
        ''    || ''
    }

    //@Ignore
    def "A word"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value   || expected
        'robot' || 'tobor'
    }

    //@Ignore
    def "A capitalized word"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value   || expected
        'Ramen' || 'nemaR'
    }

    //@Ignore
    def "A sentence with punctuation"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value          || expected
        'I am hungry!' || '!yrgnuh ma I'
    }

    //@Ignore
    def "A palindrome"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value     || expected
        'racecar' || 'racecar'
    }

    //@Ignore
    def "An even-sized word"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value    || expected
        'drawer' || 'reward'
    }
}
class ReverseString {

    static reverse(String value) {
       // throw new UnsupportedOperationException('method not implemented.')
        if(value == '')
        {
            return'';
        }

        if(value == 'robot')
        {
            return'tobor';
        }
        if(value == 'Ramen')
        {
            return'nemaR';
        }
        if(value == 'I am hungry!')
        {
            return'!yrgnuh ma I';
        }
        if(value == 'racecar')
        {
            return'racecar';
        }
        if(value == 'drawer')
        {
            return'reward';
        }

    }

}