from openai import OpenAI
client = OpenAI()

response = client.responses.create(
    model="gpt-4.1-nano",
    input="한국의 국화가 뭐야?"
)

print(response.output_text)