import random

ADJECTIVES = ["الذكي", "السريع", "القوي", "الغامض", "المبدع", "الخارق"]
NOUNS = ["الصياد", "النمر", "الصقر", "الذئب", "المبرمج", "المحارب"]

def generate_name():
    return "Ultra " + random.choice(NOUNS) + " " + random.choice(ADJECTIVES)
