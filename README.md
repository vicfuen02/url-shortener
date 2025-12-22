# url-shortener


```mermaid
---
config:
  theme: redux
  layout: fixed
---
flowchart TB
    n8[" "] --> n9[" "]
    n10[" "] --> n11[" "]
    n12[" "] --> n3["NoSQL"]
    n13[" "] --> n14[" "]
    n15[" "] --> n3
    C["Redirect <br>Service"]
    n5["Cache"]
    n2["API<br>Gateway"]
    n4[" "]
    n6[" "]
    n7["Shortener<br>Service"]
    n16["Redirect <br>Service"]

    n8@{ shape: anchor}
    n9@{ shape: anchor}
    n10@{ shape: anchor}
    n11@{ shape: anchor}
    n12@{ shape: anchor}
    n3@{ shape: cyl}
    n13@{ shape: anchor}
    n14@{ shape: anchor}
    n15@{ shape: anchor}
    n5@{ shape: cyl}
    n2@{ shape: rounded}
    n4@{ img: "https://icon.icepanel.io/Technology/png-512/Apache-Cassandra.png", h: 200, w: 200, pos: "b"}
    n6@{ img: "https://icon.icepanel.io/Technology/png-512/Redis.png", h: 200, w: 200, pos: "b"}
    n7@{ shape: rect}
    n16@{ shape: rect}
```