<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="firstName" placeholder="Enter firstName"/>
        <input type="text" name="lastName" placeholder="Enter lastName"/>
        <input type="text" name="dateOfBirth" placeholder="Enter dateOfBirth"/>
        <input type="text" name="postalCode" placeholder="Enter postalCode"/>
        <input type="file" name="file"/>
        <button type="submit">Add contact</button>
    </form>
</div><br/>

<div>
    <form method="post" action="/deletePerson">
        <input type="number" name="idFilter" placeholder="Enter id">
        <button type="submit">Delete person by id</button>
    </form>
</div><br/>

<div>
    <form method="post" action="/updatePerson">
        <input type="number" name="idFilter" placeholder="Enter id">
        <input type="text" name="firstName" placeholder="Enter new firstName"/>
        <input type="text" name="lastName" placeholder="Enter new lastName"/>
        <input type="text" name="dateOfBirth" placeholder="Enter new dateOfBirth"/>
        <input type="text" name="postalCode" placeholder="Enter new postalCode"/>
        <button type="submit">Update person by id</button>
    </form>
</div><br/>

<div>Contacts list:</div>
    <#list contacts as person>
<div>
    <b>${person.id}</b>
    <span>${person.firstName}</span>
    <span>${person.lastName}</span>
    <span>${person.dateOfBirth}</span>
    <div>
        <#if person.filename??>
            <img src="/img/${person.filename}">
        </#if>
    </div>
</div>
    </#list>
</@c.page>

