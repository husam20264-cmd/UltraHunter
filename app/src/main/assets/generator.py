import random

def generate_username(niche):
    prefixes = ["The", "Pro", "Real", "Its", "Official", "Just", "Not", "Mr", "X"]
    suffixes = ["TV", "Hub", "Lab", "Tech", "Gaming", "Live", "Pro", "Zone"]
    
    niche = niche.strip().replace(" ", "")
    if not niche: niche = "User"
        
    option1 = f"{random.choice(prefixes)}{niche}{random.choice(suffixes)}"
    option2 = f"{niche}_{random.randint(1, 9999)}"
    
    return f"✨ {random.choice([option1, option2])} ✨"
