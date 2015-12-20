# Calendae
Calendae, (pronounced 'kal-in-day') is a calendar converter is a tool that allows you to convert dates from one calendar to another, it was created to convert between Gregorian and a constructed date format Zwami but there are plans to expand support to all possible calendars including ancient ones.
# Zwami
*Zwami* is a constructed date format created and optimized for ease-of-organization and size-efficiency, it only uses six characters and it is easily organised by alphanumerical order.

*Zwami* is generally in the format of **MCDYmd** where:

**M** is the nth millenium since the beginning of the Era (since year 1)

**C** is the nth century of M starting from 1 ending with A (explained below)

**D** is the nth decade of C starting from 1 ending with A

**Y** is the nth year of D starting from 1 ending with A

**m** is the month of Y starting from 1 ending with C

**d** is the day of m starting from 1 ending with V on months with 31 days and U on months with 30 days, and so on and so forth.

Because we are aiming for a small, compact date format, it's best to use one-digit per piece of information, in order to achieve this, we have to use a base32 number system, specifically, the [base32hex system](https://en.wikipedia.org/wiki/Base32#base32hex).

Examples:

1999-04-09 becomes 2AAA49

2001-09-11 becomes 31129B

2015-12-19 becomes 3126CJ

1969-07-16 becomes 2A7A7G

in alphanumerical order, they become:

2A7A7G, 2AAA49, 31129B, 3126CJ
# Pull Requests
I am in no way a perfect coder, we all make mistakes, and we all created spaghetti code one time, so please if you see a mistake or something that could be improved please do notify me or create a pull request.
