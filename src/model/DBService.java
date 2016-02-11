package model;

import java.util.ArrayList;

public class DBService {
	private ArrayList<Language> languages = new ArrayList<Language>();
	private ArrayList<Genre> genres = new ArrayList<Genre>();
	private ArrayList<Country> countries = new ArrayList<Country>();
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	private ArrayList<Person> people = new ArrayList<Person>();
	private ArrayList<Movie> foundMovies = new ArrayList<Movie>();
	
	public DBService() {
		Movie TheShawshankRedemption = new Movie("tt0111161", "The Shawshank Redemption", 9.3, 1571534,
				" 10 March 1995", 166,
				"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
				"tt0111161.jpg");

		Director FrankDarabont = new Director("Frank Darabont",
				"Three-time Oscar nominee Frank Darabont was born in a refugee camp in 1959 in Montbeliard, France, the son of Hungarian parents who had fled Budapest during the failed 1956 Hungarian revolution. Brought to America as an infant, he settled with his family in Los Angeles and attended Hollywood High School. His first job in movies was as a production assistant on the 1981 low-budget film, Hell Night (1981), starring Linda Blair. He spent the next six years working in the art department as a set dresser and in set construction while struggling to establish himself as a writer.",
				"France", "28 January 1959", 183, "FrankDarabont.jpg");
		people.add(FrankDarabont);
		Writer StephenKing = new Writer("Stephen King",
				"Stephen Edwin King was born on September 21, 1947, at the Maine General Hospital in Portland. His parents were Nellie Ruth (Pillsbury), who worked as a caregiver at a mental institute, and Donald Edwin King, a merchant seaman. His father was born under the surname Pollock, but used the last name King, under which Stephen was born. He has an older brother, David. The Kings were a typical family until one night, when Donald said he was stepping out for cigarettes and was never heard from again. Ruth took over raising the family with help from relatives. They traveled throughout many states over several years, finally moving back to Durham, Maine, in 1958.",
				"USA", "21 September 1947", 193, "StephenKing.jpg");
		people.add(StephenKing);
		Actor TimRobbins = new Actor("Tim Robbins",
				"Born in West Covina, California, but raised in New York City, Tim Robbins is the son of former The Highwaymen singer Gil Robbins and actress Mary Robbins (nÃ©e Bledsoe). Robbins studied drama at UCLA, where he graduated with honors in 1981. That same year, he formed the Actors' Gang theater group, an experimental ensemble that expressed radical political observations through the European avant-garde form of theater.",
				"USA", "16 October 1958", 196, "TimRobbins.jpg");
		people.add(TimRobbins);
		Actor MorganFreeman = new Actor("Morgan Freeman",
				"With an authoritative voice and calm demeanor, this ever popular American actor has grown into one of the most respected figures in modern US cinema. Morgan was born in June 1937 in Memphis, Tennessee, to Mayme Edna (Revere), a teacher, and Morgan Porterfield Freeman, a barber. The young Freeman attended Los Angeles City College before serving several years in the US Air Force as a mechanic between 1955 and 1959. His first dramatic arts exposure was on the stage including appearing in an all-African American production of the exuberant musical Hello, Dolly!.",
				"USA", "1 June 1937", 188, "MorganFreeman.jpg");
		people.add(MorganFreeman);
		Actor BobGunton = new Actor("Bob Gunton",
				"Bob Gunton was born on November 15, 1945 in Santa Monica, California, USA as Robert Patrick Gunton Jr. He is an actor, known for Esaretin Bedeli (1994), Operasyon: Argo (2012) and Budala dedektif Afrika'da (1995). He has been married to Carey Pitts since August 26, 2006. He was previously married to Annie McGreevey.",
				"USA", "15 November 1945", 188, "BobGunton.jpg");
		people.add(BobGunton);
		Actor WilliamSadler = new Actor("William Sadler",
				"William Thomas Sadler was born on April 13, 1950 in Buffalo, New York, to Jane and William Sadler. He began his acting career in New York theaters, appearing in more than 75 productions over the course of 12 years. His roles included that of Sgt. Merwin J. Toomey in Neil Simon's Tony Award winning play Biloxi Blues. He is best remembered for his roles in Zor Ã¶lÃŒm 2 (1990), Bill & Ted's Bogus Journey (1991), Esaretin Bedeli (1994) and Tales from the Crypt: Demon Knight (1995). He is also a television star, appearing in such sitcoms as Roseanne (1988) and Murphy Brown (1988) and such movies-of-the weeks as Charlie and the Great Balloon Chase (1981).",
				"USA", "13 April 1950", 173, "WilliamSadler.jpg");
		people.add(WilliamSadler);
		Actor ClancyBrown = new Actor("Clancy Brown",
				"A tall, wavy-haired US actor with a deep, resonant voice, Clancy Brown has proved himself a versatile performer with first-class contributions to theater, feature films, television series and even animation. Born in Urbana, Ohio, he is the son of former US representative Clarence J. Brown, which meant Clancy spent much of his youth in close proximity to Washington, D.C. He plied his dramatic talents in the Chicago theater scene before moving onto feature film with a sinister debut performance bullying Sean Penn inside a youth reformatory in Atesten Sokaklar (1983).",
				"USA", "5 January 1959", 192, "ClancyBrown.jpg");
		people.add(ClancyBrown);
		
		TheShawshankRedemption.addCast(FrankDarabont);
		TheShawshankRedemption.addCast(StephenKing);
		TheShawshankRedemption.addCast(TimRobbins);
		TheShawshankRedemption.addCast(MorganFreeman);
		TheShawshankRedemption.addCast(BobGunton);
		TheShawshankRedemption.addCast(WilliamSadler);
		TheShawshankRedemption.addCast(ClancyBrown);

		Genre crime = new Genre("Crime");
		genres.add(crime);
		TheShawshankRedemption.addGenre(crime);
		Genre drama = new Genre("Drama");
		genres.add(drama);
		TheShawshankRedemption.addGenre(drama);
		Country usa = new Country("USA");
		countries.add(usa);
		TheShawshankRedemption.addCountry(usa);
		Language english = new Language("English");
		languages.add(english);
		TheShawshankRedemption.addLanguage(english);
		movies.add(TheShawshankRedemption);

		Movie TheGodfather = new Movie("tt0068646", "The Godfather", 9.2, 1075874, " October 1973", 175,
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
				"tt0068646.jpg");

		Director FrancisFordCoppola = new Director("Francis Ford Coppola",
				"Francis Ford Coppola was born in 1939 in Detroit, Michigan, but grew up in a New York suburb in a creative, supportive Italian-American family. His father, Carmine Coppola, was a composer and musician. His mother, Italia Coppola (née Pennino), had been an actress. Francis Ford Coppola graduated with a degree in drama from Hofstra University, and did graduate work at UCLA in filmmaking. He was training as assistant with filmmaker Roger Corman, working in such capacities as sound-man, dialogue director, associate producer and, eventually, director of Dementia 13 (1963), Coppola's first feature film. During the next four years, Coppola was involved in a variety of script collaborations, including writing an adaptation of This Property is Condemned by Tennessee Williams (with Fred Coe and Edith Sommer), and screenplays for Paris yaniyor (1966) and General Patton (1970), the film for which Coppola won a Best Original Screenplay Academy Award. In 1966, Coppola's 2nd film brought him critical acclaim and a Master of Fine Arts degree.",
				"USA", "7 April 1939", 179, "FrancisFordCoppola.jpg");
		people.add(FrancisFordCoppola);
		Writer MarioPuzo = new Writer("Mario Puzo",
				"Mario Puzo was born October 15, 1920, in Hell's Kitchen on Manhattan's (NY) West Side and, following military service in World War II, attended New York's New School for Social Research and Columbia University. His best-known novel, The Godfather, was preceded by two critically acclaimed novels, The Dark Arena and The Fortunate Pilgrim. In 1978, he published Fools Die, followed by The Sicilian (1984) and The Fourth K (1991). Mario Puzo has also written several screenplays, including Zelzele (1974), Superman (1978), and all three Godfather movies, for which he received two Academy Awards.",
				"USA", "15 October 1920", 173, "MarioPuzo.jpg");
		people.add(MarioPuzo);
		Actor MarlonBrando = new Actor("Marlon Brando",
				"Marlon Brando is widely considered the greatest movie actor of all time, rivaled only by the more theatrically oriented Laurence Olivier in terms of esteem. Unlike Olivier, who preferred the stage to the screen, Brando concentrated his talents on movies after bidding the Broadway stage adieu in 1949, a decision for which he was severely criticized when his star began to dim in the 1960s and he was excoriated for squandering his talents. No actor ever exerted such a profound influence on succeeding generations of actors as did Brando.",
				"USA", "3 April 1924", 175, "MarlonBrando.jpg");
		people.add(MarlonBrando);
		Actor Alpacino = new Actor("Alpacino",
				"One of the greatest actors in all of film history, Al Pacino established himself during one of film's greatest decades, the 1970s, and has become an enduring and iconic figure in the world of American movies.Pacino was born on April 25, 1940, in the Bronx, New York, to an Italian-American family. His parents, Rose (Gerardi) and Sal Pacino, divorced when he was young. His mother moved them into his grandparents' house. Pacino found himself often repeating the plots and voices of characters he had seen in the movies, one of his favorite activities. Bored and unmotivated in school, the young Al Pacino found a haven in school plays, and his interest soon blossomed into a full-time career.",
				"USA", "25 April 1940", 170, "Alpacino.jpg");
		people.add(Alpacino);
		Actor JamesCaan = new Actor("JamesCaan",
				"He was born in the Bronx, to Sophie (Falkenstein) and Arthur Caan, Jewish immigrants from Germany. His father was a meat dealer and butcher. The athletically gifted Caan played football at Michigan State University while studying economics, holds a black belt in karate and for several years was even a regular on the rodeo circuit, where he was nicknamed The Jewish Cowboy. However, while studying at Hofstra University, he became intrigued by acting and was interviewed and accepted at Sanford Meisner's Neighborhood Playhouse. He then won a scholarship to study under acting coach Wynn Handman and began to appear in several off-Broadway productions, including I Roam and Mandingo.",
				"USA", "26 March 1940", 176, "JamesCaan.jpg");
		people.add(JamesCaan);
		Actor RichardCastellano = new Actor("Richard Castellano",
				"Bronx born, stocky Italian-American actor who only appeared in a handful of films, yet earned some degree of immortality for his role as the loyal Corleone capo Peter Clemenza teaching Al Pacino how to shoot a crooked police captain in the iconic gangster film Baba (1972). He was originally a construction company manager, then he gained work with the New Yiddish Theatre, before breaking into film near his thirtieth birthday. However in 1970, in only his fourth film, Castellano received a Best Supporting Actor nomination for his performance in Lovers and Other Strangers (1970) and came to the attention of casting agents for Baba (1972). After his strong showing as a tough hoodlum in Baba (1972), he became somewhat typecast as a screen criminal and appeared in further crime films including Honor Thy Father (1973) and Gangster Wars (1981).",
				"USA", "4 September 1933", 175,"RichardCastellano.jpg");
		people.add(RichardCastellano);
		Actor RobertDuvall = new Actor("Robert Duvall",
				"Veteran actor and director Robert Selden Duvall was born on January 5, 1931, in San Diego, CA, to Mildred Virginia (Hart), an amateur actress, and William Howard Duvall, a career military officer who later became an admiral. Duvall majored in drama at Principia College (Elsah, IL), then served a two-year hitch in the army after graduating in 1953. He began attending The Neighborhood Playhouse School of the Theatre In New York City on the G.I. Bill in 1955, studying under Sanford Meisner along with Dustin Hoffman, with whom Duvall shared an apartment. Both were close to another struggling young actor named Gene Hackman. Meisner cast Duvall in the play The Midnight Caller by Horton Foote, a link that would prove critical to his career, as it was Foote who recommended Duvall to play the mentally disabled Boo Radley in Ugursuz Kus (1962). This was his first major role since his 1956 motion picture debut as an MP was in Yukarida biri (1956), starring Paul Newman.",
				"USA", "5 January 1931", 177, "RobertDuvall.jpg");
		people.add(RobertDuvall);
		
		TheGodfather.addCast(FrancisFordCoppola);
		TheGodfather.addCast(MarioPuzo);
		TheGodfather.addCast(MarlonBrando);
		TheGodfather.addCast(Alpacino);
		TheGodfather.addCast(JamesCaan);
		TheGodfather.addCast(RichardCastellano);
		TheGodfather.addCast(RobertDuvall);

		Language latin = new Language("Latin");
		TheGodfather.addLanguage(latin);
		languages.add(latin);
		Language italian = new Language("Italian");
		TheGodfather.addLanguage(italian);
		languages.add(italian);
		TheGodfather.addGenre(crime);
		TheGodfather.addGenre(drama);
		TheGodfather.addCountry(usa);
		TheGodfather.addLanguage(english);
		movies.add(TheGodfather);

		Movie TheDarkKnight = new Movie("tt0468569", "The Dark Knight", 9.0, 1547202, " 25 July 2008", 152,
				"When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.",
				"tt0468569.jpg");

		Director ChristopherNolan = new Director("Christopher Nolan",
				"Best known for his cerebral, often nonlinear story-telling, acclaimed writer-director Christopher Nolan was born on July 30, 1970 in London, England. Over the course of 15 years of film-making, Nolan has gone from low-budget independent films to working on some of the biggest blockbusters ever made.At 7 years old, Nolan began making short movies with his father's Super-8 camera. While studying English Literature at University College London, he shot 16-millimetre films at U.C.L.'s film society, where he learned the guerrilla techniques he would later use to make his first feature, Takip (1998), on a budget of around $6,000. The noir thriller was recognized at a number of international film festivals prior to its theatrical release, and gained Nolan enough credibility that he was able to gather substantial financing for his next film.",
				"England", "30 July 1970", 180, "ChristopherNolan.jpg");
		people.add(ChristopherNolan);
		Writer JonathanNolan = new Writer("Jonathan Nolan",
				"Attended Loyola Academy in Wilmette, Illinois, graduating in 1994.Graduated from Georgetown University in Washington, D.C. in 1999. Majored in English.Shortly after graduating from Georgetown University, Jonathan Nolan served as a production assistant on Akil Defteri (2000).Wrote the short story, Memento Mori, on which the film Akil Defteri (2000) is based.Was co-writer, with his brother Christopher Nolan, on Prestij (2006), Kara Sövalye (2008) and Kara Sövalye Yükseliyor (2012). Also co-wrote the Terminatör kurtulus (2009).",
				"England", "6 June 1976", 188, "JonathanNolan.jpg");
		people.add(JonathanNolan);
		Actor ChristianBale = new Actor("Christian Bale",
				"Christian Charles Philip Bale was born in Pembrokeshire, Wales, UK on January 30, 1974, to English parents Jennifer Jenny (James) and David Charles Howard Bale. His mother was a circus performer and his father, who was born in South Africa, was a commercial pilot. The family lived in different countries throughout Bale's childhood, including England, Portugal, and the United States. Bale acknowledges the constant change was one of the influences on his career choice.His first acting job was a cereal commercial in 1983; amazingly, the next year, he debuted on the West End stage in The Nerd. A role in the 1986 NBC mini-series Anastasia: The Mystery of Anna (1986) caught Steven Spielberg's eye, leading to Bale's well-documented role in Günes imparatorlugu (1987). For the range of emotions he displayed as the star of the war epic, he earned a special award by the National Board of Review for Best Performance by a Juvenile Actor.",
				"Wales", "30 January 1974", 183, "ChristianBale.jpg");
		people.add(ChristianBale);
		Actor HeathLedger = new Actor("Heath Ledger",
				"When a hunky, twenty-year-old heart-throb Heath Ledger first came to the attention of the public in 1999, it was all too easy to tag him as a pretty boy and an actor of little depth. He spent several years trying desperately to sway this image, but this was a double-edged sword.Heath Ledger was born on the fourth of April 1979, in Perth, Western Australia, to Sally (Ramshaw), a teacher of French, and Kim Ledger, a mining engineer who also raced cars. As the story goes, in junior high school it was compulsory to take one of two electives, either cooking or drama. As Heath could not see himself in a cooking class he tried his hand at drama. Heath was talented, however the rest of the class did not acknowledge his talent. When he was seventeen he and a friend decided to pack up, leave school, take a car and rough it to Sydney. Heath believed Sydney to be the place where dreams were made or, at least, where actors could possibly get their big break. Upon arriving in Sydney with a purported sixty-nine cents to his name, Heath tried everything to get a break.",
				"USA", "4 April 1979", 185, "HeathLedger.jpg");
		people.add(HeathLedger);
		Actor AaronEckhart = new Actor("Aaron Eckhart",
				"Aaron Eckhart was born on March 12, 1968 in Cupertino, California, USA as Aaron Edward Eckhart. He is an actor and producer, known for Kara Sövalye (2008), Dünya Istilasi: Los Angeles Savasi (2011) and Sigara Ictiginiz Icin Tesekkurler (2005).",
				"USA", "12 March 1968", 180, "AaronEckhart.jpg");
		people.add(AaronEckhart);
		Actor MichaelCaine = new Actor("Michael Caine",
				"Michael Caine was born Maurice Joseph Micklewhite in London, to Ellen Frances Marie (Burchell), a charlady, and Maurice Joseph Micklewhite, a fish-market porter. He left school at 15 and took a series of working-class jobs before joining the British army and serving in Korea during the Korean War, where he saw combat. Upon his return to England he gravitated toward the theater and got a job as an assistant stage manager. He adopted the name of Caine on the advice of his agent, taking it from a marquee that advertised Denizde isyan (1954).",
				"USA", "5 January 1959", 192, "MichaelCaine");
		people.add(MichaelCaine);
		Actor MaggieGyllenhaal = new Actor("Maggie Gyllenhaal",
				"Academy Award-nominated actress Maggie Gyllenhaal was born on November 16, 1977, on the Lower East Side of Manhattan in New York City. Her parents, Naomi Foner (née Achs) and Stephen Gyllenhaal, are both filmmakers, and her brother is actor Jake Gyllenhaal. Her mother is from an Ashkenazi Jewish family, while her father has Swedish, English, Swiss-German, and German ancestry.Maggie made her film debut in Stephen's film Su Sehri (1992). She had sporadic roles throughout her teenage years, though she stepped away to receive a degree in literature from Columbia University in 1999. In addition, she studied briefly at the Royal Academy of Dramatic Arts in London, which helped with her post-graduation transition back in to acting.",
				"USA", "16 November 1977", 175,"MaggieGyllenhaal");
		people.add(MaggieGyllenhaal);
		
		TheDarkKnight.addCast(ChristopherNolan);
		TheDarkKnight.addCast(JonathanNolan);
		TheDarkKnight.addCast(ChristianBale);
		TheDarkKnight.addCast(HeathLedger);
		TheDarkKnight.addCast(AaronEckhart);
		TheDarkKnight.addCast(MichaelCaine);
		TheDarkKnight.addCast(MaggieGyllenhaal);

		Language Mandarin = new Language("Mandarin");
		languages.add(Mandarin);
		TheDarkKnight.addLanguage(Mandarin);
		Genre action = new Genre("Action");
		genres.add(action);
		TheDarkKnight.addGenre(action);

		TheDarkKnight.addGenre(drama);
		TheDarkKnight.addGenre(crime);
		Country UK = new Country("UK");
		countries.add(UK);
		TheDarkKnight.addCountry(UK);
		TheDarkKnight.addCountry(usa);

		TheDarkKnight.addCountry(usa);

		TheDarkKnight.addLanguage(english);
		movies.add(TheDarkKnight);

		Movie FightClub = new Movie("tt0137523", "Fight Club", 8.9, 1242964, "  10 December 1999", 139,
				"An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soap maker, forming an underground fight club that evolves into something much, much more...",
				"tt0137523.jpg");

		Director DavidFincher = new Director(" David Fincher",
				"David Fincher was born in 1962 in Denver, Colorado, and was raised in Marin County, California. When he was 18 years old he went to work for John Korty at Korty Films in Mill Valley. He subsequently worked at ILM (Industrial Light and Magic) from 1981-1983. Fincher left ILM to direct TV commercials and music videos after signing with N. Lee Lacy in Hollywood. He went on to found Propaganda in 1987 with fellow directors Dominic Sena, Greg Gold and Nigel Dick. Fincher has directed TV commercials for clients that include Nike, Coca-Cola, Budweiser, Heineken, Pepsi, Levi's, Converse, AT&T and Chanel. He has directed music videos for Madonna, Sting, The Rolling Stones, Michael Jackson, Aerosmith, George Michael, Iggy Pop, The Wallflowers, Billy Idol, Steve Winwood, The Motels and, most recently, A Perfect Circle.As a film director, he has achieved huge success with Yedi (1995), Dövüs Kulübü (1999) and, Panik odasi (2002).",
				"USA", "28 August 1962", 184, "DavidFincher.jpg");
		people.add(DavidFincher);
		Writer ChuckPalahniuk = new Writer("Chuck Palahniuk",
				"Chuck is a low key writer who never stops writing and taking down notes to file away for future writing. Very funny, very creative and very thought provoking. His books often make you look at yourself in ways that you would never have before. Same goes for the world, he will make you notice things that you never did. He is of French and Russian descent but his last name is from Ukraine. He gained recognition with his first book Fight Club which was later made into a film by 20th Century Fox. He went on to gain popularity as his later novels which include Survivor, Invisible Monsters, Choke, Lullaby, and Haunted. More recently (2003) he has written a travel book about his hometown Portland, Oregon entitled Fugitives & Refugees. His newest novel is entitled Rant.",
				"USA", "21 February 1962", 180, "ChuckPalahniuk.jpg");
		people.add(DavidFincher);
		Actor BradPitt = new Actor("Brad Pitt",
				"An actor and producer known as much for his versatility as he is for his handsome face, Golden Globe-winner Brad Pitt's most widely recognized role may be Tyler Durden in Dövüs Kulübü (1999). But his portrayals of Billy Beane in Kazanma Sanati (2011), and Rusty Ryan in the remake of Ocean's 11 (2001) and its sequels, also loom large in his filmography.Pitt was born William Bradley Pitt on December 18th, 1963, in Shawnee, Oklahoma, and was raised in Springfield, Missouri. He is the son of Jane Etta (Hillhouse), a school counselor, and William Alvin Pitt, a truck company manager. He has a younger brother, Douglas (Doug) Pitt, and a younger sister, Julie Neal Pitt. At Kickapoo High School, Pitt was involved in sports, debating, student government and school musicals. Pitt attended the University of Missouri, where he majored in journalism with a focus on advertising. He occasionally acted in fraternity shows. He left college two credits short of graduating to move to California. Before he became successful at acting, Pitt supported himself by driving strippers in limos, moving refrigerators and dressing as a giant chicken while working for el Pollo Loco.",
				"USA", "18 December 1963", 180, "BradPitt.jpg");
		people.add(BradPitt);
		Actor EdwardNorton = new Actor("Edward Norton",
				"Edward Harrison Norton was born on August 18, 1969, in Boston, Massachusetts, and was raised in Columbia, Maryland.His mother, Lydia Robinson Robin (Rouse), was a foundation executive and teacher of English, and a daughter of famed real estate developer James Rouse, who developed Columbia, MD; she passed away of brain cancer on March 6, 1997. His father, Edward Mower Norton, Jr., was an environmental lawyer and conservationist, who works for the National Trust for Historic Preservation. Edward has two younger siblings, James and Molly.",
				"USA", "18 August 1969", 183, "EdwardNorton.jpg");
		people.add(EdwardNorton);
		Actor HelenaBonhamCarter = new Actor("Helena Bonham Carter",
				"Helena Bonham Carter is an actress of great versatility, one of the UK's finest and most successful.Bonham Carter was born May 26, 1966 in Golders Green, London, England, the youngest of three children of Elena (née Propper de Callejón), a psychotherapist, and Raymond Bonham Carter, a merchant banker. She is the great-granddaughter of former Prime Minister Herbert H. Asquith, and her blue-blooded family tree also contains Barons and Baronesses, diplomats, and a director, Bonham Carter's great-uncle Anthony Asquith, who made Pygmalion (1938) and The Importance of Being Earnest (1952), among others. Cousin Crispin Bonham-Carter is also an actor. Her maternal grandfather, Eduardo Propper de Callejón, was a Spanish diplomat who was awarded the honorific Righteous Among the Nations, by Israel, for helping save Jews during World War II (Eduardo's own father was a Czech Jew). Helen's maternal grandmother, Hélène Fould-Springer, was from an upper-class Jewish family from France, Austria, and Germany, and later converted to her husband's Catholic faith.",
				"England", "26 May 1966", 157, "HelenaBonhamCarter.jpg");
		people.add(HelenaBonhamCarter);
		Actor MeatLoaf = new Actor("Meat Loaf",
				"Meat Loaf was born in Texas, and moved to Los Angeles in 1967 to play in local bands and appear in musicals such as Hair and As You Like It. He made his film debut with a memorable role in cult film The Rocky Horror Picture Show (1975). In 1977, he and lyricist Jim Steinman released an operatic rock album called Bat Out Of Hell, the record was huge and has sold 35,000,000 copies worldwide. However, the tour promoting the album took a toll on Meat's voice and left him unable to sing on the follow-up record Bad For Good. Meat Loaf stayed in the dark through the eighties doing 4 records which never got any airplay or chart position in the US. Meat Loaf appeared in films Out of Bounds (1986) as a Pilot, and The Squeeze (1987) with Michael Keaton. But after getting back together with Steinman, they delivered a powerful sequel Bat Out Of Hell II which went to #1 in the US and UK. Bat II has now sold an excess of 20,000,000 copies. His TV credits include the Soldier being held prisoner in Vietnam in Lightning Force (1991), a mad Doctor who invents a serum to keep zombies from deteriorating in Monsters (1988) and a slick Landlord of a restaurant who ends up on the menu in HBO series Tales from the Crypt (1989). Meat Loaf has also appeared in Crazy in Alabama (1999) and Dövüs Kulübü (1999).",
				"USA", "27 September 1947", 179, "MeatLoaf.jpg");
		people.add(MeatLoaf);
		Actor CZachGrenier = new Actor("CZach Grenier",
				"Zach Grenier was born on February 12, 1954 in Englewood, New Jersey, USA as James Hampton Grenier. He is an actor, known for Dövüs Kulübü (1999), Rescue Dawn (2006) and Köstebek (1997). He is married to Lynn Coutant Bailey.",
				"USA", "5 January 1959", 192, "CZachGrenier.jpg");
		people.add(CZachGrenier);
		
		FightClub.addCast(DavidFincher);
		FightClub.addCast(ChuckPalahniuk);
		FightClub.addCast(BradPitt);
		FightClub.addCast(EdwardNorton);
		FightClub.addCast(HelenaBonhamCarter);
		FightClub.addCast(MeatLoaf);
		FightClub.addCast(CZachGrenier);

		FightClub.addGenre(drama);
		Country germany = new Country("Germany");
		countries.add(germany);
		TheDarkKnight.addCountry(germany);
		FightClub.addCountry(usa);

		FightClub.addLanguage(english);
		movies.add(FightClub);

		Movie Inception = new Movie("tt1375666", "Inception", 8.8, 1346663, "  30 July 2010 ", 148,
				"A thief who steals corporate secrets through use of the dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO..",
				"tt1375666.jpg");
		
		Actor LeonardoDiCaprio = new Actor("Leonardo DiCaprio",
				"Few actors in the world have had a career quite as diverse as Leonardo DiCaprio's. DiCaprio has gone from relatively humble beginnings, as a supporting cast member of the sitcom Growing Pains (1985) and low budget horror movies, such as Critters 3 (1991), to a major teenage heartthrob in the 1990s, as the hunky lead actor in movies such as Romeo ve Juliet (1996) and Titanik (1997), to then become a leading man in Hollywood blockbusters, made by internationally renowned directors such as Martin Scorsese and Christopher Nolan.",
				"USA", "11 November 1974", 183, "LeonardoDiCaprio.jpg");
		people.add(LeonardoDiCaprio);
		Actor JosephGordonLevitt = new Actor("Joseph Gordon-Levitt",
				"Joseph Leonard Gordon-Levitt was born February 17, 1981 in Los Angeles, California, to Jane Gordon and Dennis Levitt. Joseph was raised in a Jewish family with his late older brother, Dan Gordon-Levitt, who passed away in October 2010. His parents worked for the Pacifica Radio station KPFK-FM and his maternal grandfather, Michael Gordon, had been a well-known movie director. After working for several years as a child actor, Joseph became better known for starring on the hit television series 3rd Rock from the Sun (1996), for which he earned two Hollywood Reporter Young Star Awards. In addition, the show earned three Screen Actors Guild Award nominations for Outstanding Peformance by an Ensemble in a Comedy Series. Prior to his success on television, Joseph had already worked steadily in feature films, debuting in the Robert Redford film Bizi ayiran nehir (1992). He won a Young Artist Award for the latter film. During the 1990s, he also co-starred in the films Angels in the Outfield (1994), Tuzak (1996), Halloween 7 - Korku bayrami (1998), and Senden nefret etmemin 10 sebebi (1999).",
				"USA", "17 February 1981", 176, "JosephGordonLevitt.jpg");
		people.add(JosephGordonLevitt);
		Actor EllenPage = new Actor("Ellen Page",
				"Ellen Philpotts-Page was born on February 21, 1987, in Halifax, Nova Scotia, to Martha Philpotts, a teacher, and Dennis Page, a graphic designer. Page wanted to start acting at an early age and attended the Neptune Theater School. She began her career at the age of 10 on the award-winning television series Pit Pony (1999), for which she received a Gemini nomination and a Young Artist Awards nomination. Later, Page appeared in Marion Bridge (2002), which won the award for Best Canadian First Feature at the Toronto International Film Festival. She won a Gemini Award for her role of Lilith in the first season of ReGenesis (2004), a one-hour drama for TMN/Movie Central, and for the cable feature, Mrs. Ashboro's Cat (2004), for Best Performance in a Children's or Youth Program or Series. In addition, Page appeared in the cult hit TV series Trailer Park Boys (2001).As the lead in David Slade's Lolipop (2005), which premiered at the Sundance Film Festival, Page garnered much praise for her tour de force performance as a 14-year-old girl who meets a 30-year-old photographer on the Internet and then looks to expose him as pedophile. Films that followed included the title role of Bruce McDonald's The Tracey Fragments (2007); Bir Amerikan Suçu (2007), also starring Catherine Keener; and the third installation of the X-Men franchise, X-men: Son direnis (2006), where she played Kitty Pryde.",
				"Canada", "21 February 1987", 155, "EllenPage.jpg");
		people.add(EllenPage);
		Actor TomHardy = new Actor("Tom Hardy",
				"With his breakthrough performance as Eames in Christopher Nolan's science fiction thriller Baslangiç (2010), English actor Tom Hardy has been brought to the attention of mainstream audiences worldwide. But the versatile actor has been steadily working on both stage and screen since his television debut in the mini-series Kardesler Takimi (2001). After being cast in the World War II drama, Hardy left his studies at the prestigious Drama Centre in London and was subsequently cast in Ridley Scott's Kara sahin düstü (2001) and as the villain Shinzon in Uzay Yolu: Nemesis (2002).Tom was born on September 15, 1977 in Hammersmith, London; his mother, Elizabeth Anne (Barrett), is an artist and painter, and his father, Edward Hardy, is a writer. He is of English and Irish descent. Hardy was brought up in East Sheen, London, and first studied at Reed's School. His education continued at Tower House School, then at Richmond Drama School, and subsequently at the Drama Centre London. After winning a modeling competition at age 21, he had a brief contract with the agency Models One.",
				"England", "15 September 1977", 175, "TomHardy.jpg");
		people.add(TomHardy);
		Actor KenWatanabe = new Actor("Ken Watanabe", "", "Japan", "21 October 1959", 184, "KenWatanabe");
		people.add(KenWatanabe);
		
		Inception.addCast(ChristopherNolan);
		Inception.addCast(FrankDarabont);
		Inception.addCast(StephenKing);
		Inception.addCast(LeonardoDiCaprio);
		Inception.addCast(JosephGordonLevitt);
		Inception.addCast(EllenPage);
		Inception.addCast(TomHardy);
		Inception.addCast(KenWatanabe);

		Language French  = new Language("French");
		Inception.addLanguage(French);
		languages.add(French);
		Language Japanese = new Language("Japanese");
		Inception.addLanguage(Japanese);
		languages.add(Japanese);
		
		
		Genre mystery = new Genre("Mystery");
		genres.add(mystery);
		Inception.addGenre(mystery);
		Genre scientific = new Genre("Scientific");
		genres.add(scientific);
		Inception.addGenre(scientific);
		Inception.addGenre(action);
		Inception.addCountry(UK);
		Inception.addCountry(usa);

		Inception.addLanguage(english);
		movies.add(Inception);
		// Forest Gump 
		// matrix
		// Seven
		// Green mile
		// prestige
		// Gran torino
		// The Imitation Game
	}
	public ArrayList<Movie> getMovies(){
		ArrayList<Movie> allMovies = new ArrayList<Movie>();
		for(Movie m : this.movies){
			allMovies.add(m);
		}
		return allMovies;
	}
	
	public Movie getMovie(String imdbID){
		
		for (Movie m : movies){
			if (m.getImdbID().equalsIgnoreCase(imdbID)){
				return m;
			}
		}
		return null;
	}
	
	public Movie getMovieByTitle(String title){
		System.out.println(movies.size());
		for (Movie m : movies){
			if (m.getTitle().equalsIgnoreCase(title)){
				return m;
			}
		}
		return null;
	}
	
	public Person getPerson(String castName) {
		Person foundedPerson = null;
		for (Person p : people){
			if (p.getName().equalsIgnoreCase(castName))
				foundedPerson = p;
		}
		
		for(Movie m : movies){
			for(Person person : m.getCast()){
				if (person.getName().equalsIgnoreCase(foundedPerson.getName())){
					foundedPerson.addOwnMovie(m);
				}
			}
		}
		return foundedPerson;
	}
	public ArrayList<Language> getLanguages() {
		return languages;
	}
	public ArrayList<Genre> getGenres() {
		return genres;
	}
	public ArrayList<Country> getCountries() {
		return countries;
	}

	public void findMoviesByGenre(Object[] genreNames){
		for(Movie m : movies){
			for(Object searhingGenre : genreNames){
				for(Genre g : m.getGenres()){
					if (g.getName().equalsIgnoreCase(searhingGenre.toString())){
						if (!isContain(foundMovies, m))
							foundMovies.add(m);
					}
				}
			}
		}
	}
	
	public void findMoviesByImdbRating(int imdbRating, String quality){
		for (Movie m : foundMovies){
			
		}
	}
	
	private Boolean isContain(ArrayList<Movie> movies, Movie movie){
		for (Movie m : movies){
			if (m.getImdbID().equalsIgnoreCase(movie.getImdbID())){
				return true;
			}
		}
		return false;
	}
}