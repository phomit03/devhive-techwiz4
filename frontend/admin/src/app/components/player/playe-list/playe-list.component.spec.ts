import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayeListComponent } from './playe-list.component';

describe('PlayeListComponent', () => {
  let component: PlayeListComponent;
  let fixture: ComponentFixture<PlayeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PlayeListComponent]
    });
    fixture = TestBed.createComponent(PlayeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
