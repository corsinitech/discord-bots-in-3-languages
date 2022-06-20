import discord

client = discord.Client()


def token_reader():
    token_file = open("./token.txt", "r")
    token = token_file.read()
    return token


@client.event
async def on_ready():
    print('We have logged in as {0.user}'.format(client))


@client.event
async def on_message(message):
    if message.author == client.user:
        return

    if message.content.startswith('!ping'):
        await message.channel.send('Pong!')

    if message.content.startswith('!roles'):
        await message.channel.send(f'{message.author} has these roles:')

        for i in range(len(message.author.roles) - 1):
            await message.channel.send(f'{message.author.roles[i + 1]}')


client.run(token_reader())
