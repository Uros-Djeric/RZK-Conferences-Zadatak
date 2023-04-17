# RZK
Razvoj Zasnovan na Komponentama

Wildfly server, njegova konfiguracija, Session/Stateless bean-ovi, Message-driven bean-ovi, Webservisi, REST metode, ...


Postavka samog zadatka: 

Napraviti web aplikaciju preko koje organizatori naučnih konferencija mogu
da šalju informacije o konferencijama koje organizuju. Od informacija se šalju
naziv konferencije, država i grad gde se konferencija organizuje, datum
početka i završetka i naučna oblast konferencije.
Servlet ove podatke šalje stateless session bean-u koji kreira JMS poruke i
prosleđuje ih u queue “conference”. Message driven bean ConferenceMDB
prihvata poruke, podatke iz poruke upisuje u bazu podataka u tabelu
Conference. Podatke dobijene u poruci dopunjava podacima o državi
dobijenim preko javnog web servisa Country Details. Podaci se dopunjavaju
podacima o ISO kodu države, pozivnom broju (Dialing code) za državu I
valutom koja se koristi. Opis ovog web servisa se nalazi na adresi:

http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.
wso?WSDL

Nakon unošenja svih podataka u bazu podataka, MDB poruke prosleđuje u
topic “confinfo”. Te poruke iz topic-a čitaju dva message driven bean-a koji
koji simuliraju korisnike topic-a. Jedan MDB ispisuje informacije na konzolu o
konferencijama koje se održavaju u Nemačkoj, a drugi o konferencijama koje
se održavaju u Francuskoj.
Takođe, unutar aplikacije potrebno je implementirati web servis koji za zadatu
naučnu oblast vraća podatke o svim konferencijama koje još nisu održane.
Za sam kraj napraviti dva rest web servisa(jedan post i jedan get) koji
omogućavaju registrovanje na konferenciju, kao i rest servis koji vraća sva
predavanja određenog predavača na konferenciji.
