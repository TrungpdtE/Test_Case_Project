
import random

def generate_idcard():
    # generate random id card with the given format and return it as string
    id_num = str(random.randint(100000, 200000))
    name = random.choice(["John Doe", "Jane Smith", "Bob Johnson", "Alice Lee", "David Kim", "Sarah Green", "Adam Brown", "John Lech", "Jack Smith", "Lisa Wilson","Daisy Duck", "Donald Duck",
"Eve", "Wall-E",
"Lilo", "Stitch",
"Sully", "Mike",
"Jack", "Jill",
"Nora", "Dora",
"Shaggy", "Scooby",
"Daphne", "Fred",
"Drake", "Josh",
"Hinata", "Naruto",
"MitsuriKanroji", "ObanaiIguro",
"ShinobuKocho", "Giyu Tomioka",
"Nezuko", "Zenitsu",
"Tanjiro", "Kanao",
"MakiseKurisu", "Okabe Rintaro",
"Viktor", "Yuri Miyazono",
"Zero Two", "Hiro Richards",
"Jessica Jones", "Luke Cage",
"Iris West", "Barry Allen (The Flash)",
"Lois Lane", "Clark Kent",
"Jean", "Diluc",
"Childe", "Lumine",
"Watson",
"Alana", "Marko",
"Queen Bee", "Jay-Z",
"Luna", "Alex",
"Sugar", "Spice",
"Heart Throb", "Heart Breaker",
"Wolf of North", "Lion of South",
"Sasuke", "Sakura",
"Baby", "Johnny",
"Iron Man", "Pepper Pots", "Dumb", "Dumber",
"Batman", "Robin",
"Pooh", "Piglet",
"Calvin", "Hobbes",
"Romeo", "Juliet",
"Shrek", "Donkey",
"Tweedledum", "Tweedledee",
"Simon", "Garfunkel",
"Mario", "Luigi",
"Ash", "Pikachu",
"Mulder", "Scully",
"Jasmine", "Aladdin",
"Princess Ariel", "Prince Eric",
"Tramp", "Lady",
"Prince Charming", "Cinderella",
"Prince Phillip", "Princess Aurora",
"Minnie Mouse", "Mickey",
"Usagi Tsukino", "Mamoru Chiba",
"Ichigo Kurosaki", "Orihime Inoue",
"MakaAlbern", "Soul Eater",
"Big Barda", "Mister Miracle",
"Scarlet Witch", "Vision",
"Black Widow", "Hawkeye",
"Titanium",
"Former Miss Worlds",
"Vandelay Industries",
"Gonzo Wolfpack",
"Vague Death Poets",
"Son of Pitch",
"Bloodbath Architects",
"Sinister Epic",
"Feisty Females",
"The Big Egos",
"Rot Kill Squad",
"Optimistic Geeks",
"Purple Mafia",
"Bromagination",
"Endzone Matter",
"Crew of Honored",
"Trojans",
"Feigned Anatomy",
"Lords of Absurd",
"The Rhythms",
"Close Shave",
"The Human Targets",
"Beige Overkill", "Ramona Flowers", "Scott Pilgrim",
"Apollo", "Midnighter",
"Scott Summers", "Jean Grey",
"Harley Quinn", "Poison Ivy",
"Spiderman", "Mary Jane",
"Bird", "Bee",
"Knucklehead", "Chucklehead",
"Joker", "Poker",
"Stark", "Targaryen",
"Bert", "Ernie",
"Monica", "Chandler", "Sweetie Pie", "Cutie Pie",
"Yin", "Yang",
"French Fries", "Ketchup",
"Caramel", "Popcorn",
"Butter", "Popcorn",
"Cheese", "Fries",
"Nutella", "Strawberry",
"Chocolate", "Fudge",
"Waffle", "Cookie",
"Baby Poo", "Baby Bear",
"Funny", "Bunny",
"Tootsie", "Wootsie",
"Cherry", "Cream",
"Mac", "Cheese",
"Pepper", "Salt",
"Chunky Peanut Butter", "Creamy Peanut Butter",
"Peanut Butter", "Jam",
"Marshmallow", "Hot Chocolate",
"Tom", "Jerry",
"Edward", "Winry",
"RyuujiTakasu", "Taiga Aisaka",
"Loon Messiahs",
"Vision quest",
"Broflakes",
"Your Pace or Mine?",
"Beige Overkill",
"Vengeance of the Faithful",
"Angry Apes",
"Benchwarmers United",
"Poetic Death Attack",
"Sales R Us",
"Hospitable Violence",
"Blaze of Darkness",
"The Fixers",
"Overconfident",
"Abject Curve",
"Jesse James",
"Prank Masters",
"Maximus",
"Infamous Assassins",
"Wonder Women",
"Immovables",
"Dapper Dundee Kill",
"Vigor Things",
"The Baha Badboys",
"Alcohooligans",
"Thunder Buddies",
"Fire and Ice",
"Alpha and Omega",
"Salt and Pepper",
"Bonnie and Clyde",
"Rock and Roll",
"Thunder and Lightning",
"Sun and Moon",
"Beauty and the Beast",
"Romeo and Juliet",
"Adam and Eve",
"Batman and Catwoman",
"Superman and Lois Lane",
"Bonnie and Damon",
"Mike and Sulley",
"Will and Grace",
"Salt and Vinegar",
"Simon and Garfunkel",
"Starsky and Hutch",
"Biggie and Tupac",
"Harold and Kumar",
"Boys and Girls",
"Rick and Morty",
"John and Yoko",
"Elvis and Priscilla",
"Kenan and Kel",
"Shaggy and Velma",
"Drake and Rihanna",
"Kim and Kanye",
"Tom and Jerry",
"Luke and Leia",
"Thelma and Louise",
"Harry and Ron",
"Fred and George",
"Kirk and Spock",
"Peter and Paul",
"Charlie and the Chocolate Factory",
"Black and White",
"Red and Blue",
"Coffee and Cream",
"Thunder and Fire",
"Peace and Love",
"Hope and Faith",
"Time and Space",
"Truth and Justice",
"War and Peace",
"Light and Darkness",
"Rain and Sunshine",
"Love and Hate",
"Life and Death",
"Freedom and Equality",
"Justice and Equality",
"Good and Evil",
"Joy and Sorrow",
"Laughter and Tears",
"Success and Failure",
"Victory and Defeat",
"Courage and Fear",
"Strength and Weakness",
"Health and Wealth"])
    gender = random.choice(["Male", "Female"])
    date_of_birth = f"{random.randint(1, 28)}/{random.randint(1, 12)}/{random.randint(1950, 2010)}"
    address = f"{random.randint(100, 999)} {random.choice(['Main St', 'Oak Ave', 'Elm Rd', 'Maple Blvd', 'Pine Ln', 'Walnut Ave', 'Cedar St', 'Oak St', 'Pine St', 'Elm St'])}"
    phone_num = str(random.randint(1000000, 9999999))
    return f"{id_num},{name},{gender},{date_of_birth},{address},{phone_num}"

def generate_payment_info(idcard_list):
    # generate random payment information with the given format and return it as string
    choices = ["idcard", "phone", "idcard+0.01"]
    choice_weights = [0.4, 0.4, 0.2]
    payment_info = []
    for i in range(30):
        choice = random.choices(choices, weights=choice_weights)[0]
        if choice == "idcard":
            payment_info.append(random.choice(idcard_list).split(",")[0])
        elif choice == "phone":
            payment_info.append(str(random.randint(1000000, 9999999)))
        else:
            idcard = random.choice(idcard_list).split(",")
            payment_info.append(f"{idcard[0]},0.01")
    return "\n".join(payment_info)

def generate_top_up_history(payment_info_list):
    # generate random top up history with the given format and return it as string
    top_up_history = []
    for i in range(30):
        payment = random.choice(payment_info_list).split(",")
        if len(payment) == 1:
            id_type = "CC"
            id_num = payment[0]
        else:
            id_type = "BA" if payment[1] == "0.01" else "EW"
            id_num = payment[0]
        amount = random.randint(0, 1000)
        top_up_history.append(f"{id_type},{id_num},{amount}")
    return "\n".join(top_up_history)

def generate_bill(payment_info_list):
    # generate random bill with the given format and return it as string
    bill = []
    for i in range(30):
        payment = payment_info_list[i].split(",")
        id_type = "CC" if len(payment) == 1 else "BA" if payment[1] == "0.01" else "EW"
        id_num = payment[0]
        amount = random.randint(50, 300)
        category = random.choice(["Clothing", "Drink", "Elec"])
        bill.append(f"{i+1},{amount},{category},{id_type},{id_num}")
    return "\n".join(bill)

# generate idcard.txt
idcard_list = [generate_idcard() for i in range(1000)]
with open("IDCard.txt", "w") as f:
    f.write("\n".join(idcard_list))

# generate payment_information.txt
payment_info = generate_payment_info(idcard_list)
with open("PaymentInformation.txt", "w") as f:
    f.write(payment_info)

# generate top_up_history.txt
top_up_history = generate_top_up_history(payment_info.split("\n"))
with open("TopUpHistory.txt", "w") as f:
    f.write(top_up_history)

# generate bill.txt
bill = generate_bill(payment_info.split("\n"))
with open("Bill.txt", "w") as f:
    f.write(bill)
