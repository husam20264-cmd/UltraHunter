import random

PREFIXES = ["The", "Pro", "Real", "Its", "Official", "Just", "Not", "Mr", "X", "Ultra", "Smart"]
SUFFIXES = ["TV", "Hub", "Lab", "Tech", "Gaming", "Live", "Pro", "Zone", "AI", "X"]

AR_ADJECTIVES = ["الذكي", "السريع", "القوي", "الغامض", "المبدع", "الخارق", "الذهبي"]
AR_NOUNS = ["الصياد", "النمر", "الصقر", "الذئب", "المبرمج", "المحارب", "الخبير"]

def clean_niche(niche):
    niche = str(niche or "").strip().replace(" ", "")
    return niche if niche else "Gaming"

def generate_username(niche="Gaming"):
    niche = clean_niche(niche)

    options = [
        f"{random.choice(PREFIXES)}{niche}{random.choice(SUFFIXES)}",
        f"{niche}_{random.randint(100, 9999)}",
        f"{random.choice(PREFIXES)}_{niche}_{random.choice(SUFFIXES)}",
        f"{niche}{random.choice(SUFFIXES)}{random.randint(10, 99)}",
    ]

    return f"✨ {random.choice(options)} ✨"

def generate_name():
    return "Ultra " + random.choice(AR_NOUNS) + " " + random.choice(AR_ADJECTIVES)

def generate_many(niche="Gaming", count=5):
    try:
        count = int(count)
    except Exception:
        count = 5

    count = max(1, min(count, 20))
    return "\n".join(generate_username(niche) for _ in range(count))

def health_check():
    return "Python generator is working"
